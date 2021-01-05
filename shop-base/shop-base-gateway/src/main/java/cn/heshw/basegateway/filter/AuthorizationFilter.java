package cn.heshw.basegateway.filter;

import cn.heshw.auth.JWTUtil;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationFilter implements GlobalFilter, Ordered {
  @Value("${allow-host}")
  private String allowHost;

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    final String host = Objects.requireNonNull(exchange.getRequest().getHeaders().getHost())
        .getHostName();
    final ServerHttpResponse response = exchange.getResponse();
    if (host.equals(allowHost)) {
      final String token = CollectionUtils.firstElement(exchange.getRequest().getHeaders().get("Authorization"));
      if (token != null) {
        try {
          JWTUtil.checkTokenValid(token);
        } catch (Exception e) {
          response.setStatusCode(HttpStatus.UNAUTHORIZED);
          return null;
        }
      }
      return chain.filter(exchange);
    }
    return null;
  }

  /**
   * 调整为最大优先级
   * @return
   */
  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }
}