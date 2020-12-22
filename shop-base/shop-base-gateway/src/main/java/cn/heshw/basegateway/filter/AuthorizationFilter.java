package cn.heshw.basegateway.filter;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationFilter implements GatewayFilter, Ordered {

  @Value("${allow-host}")
  private String allowHost;

  public void setAllowHost(String allowHost) {
    this.allowHost = allowHost;
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    final String host = Objects.requireNonNull(exchange.getRequest().getHeaders().getHost())
        .getHostName();
    if (host.equals(allowHost)) {
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