package cn.heshw.basegateway.filter;

import cn.heshw.auth.JWTUtil;
import cn.heshw.basegateway.config.MySwaggerResourceProvider;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RefreshScope
public class AuthorizationFilter implements GlobalFilter, Ordered {

  @Value("${allow-paths}")
  private String[] allowPaths;

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    final String path = exchange.getRequest().getPath().value();
    if (path.endsWith(MySwaggerResourceProvider.SWAGGER2URL)) {
      return chain.filter(exchange);
    }
    for (String allowPath : allowPaths) {
      if (allowPath.equals(path)) {
        return chain.filter(exchange);
      }
    }
    final ServerHttpResponse response = exchange.getResponse();
    final String token = CollectionUtils
        .firstElement(exchange.getRequest().getHeaders().get("Authorization"));
    try {
      if (token != null) {
        JWTUtil.checkTokenValid(token);
      } else {
        throw new Exception("未登录，请登录");
      }
    } catch (Exception e) {
      response.setStatusCode(HttpStatus.UNAUTHORIZED);
      DataBuffer buffer = response.bufferFactory()
          .wrap(e.getMessage().getBytes(StandardCharsets.UTF_8));
      response.setStatusCode(HttpStatus.UNAUTHORIZED);
      //指定编码，否则在浏览器中会中文乱码
      response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
      return response.writeWith(Mono.just(buffer));
    }
    return chain.filter(exchange);
  }

  /**
   * 调整为最大优先级
   *
   * @return
   */
  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }
}