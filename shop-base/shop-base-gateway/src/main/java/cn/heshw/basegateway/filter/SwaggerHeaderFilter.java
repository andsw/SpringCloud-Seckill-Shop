package cn.heshw.basegateway.filter;

import cn.heshw.basegateway.config.MySwaggerResourceProvider;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory<Object> {
  private static final String HEADER_NAME = "X-Forwarded-Prefix";

  @Override
  public GatewayFilter apply(Object config) {
    return (exchange, chain) -> {
      ServerHttpRequest request = exchange.getRequest();
      String path = request.getURI().getPath();
      if (!StringUtils.endsWithIgnoreCase(path, MySwaggerResourceProvider.SWAGGER2URL)) {
        return chain.filter(exchange);
      }
      String basePath = path.substring(0, path.lastIndexOf(MySwaggerResourceProvider.SWAGGER2URL));
      // 带上"X-Forwarded-Prefix"请求头后请求转发
      ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
      ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
      return chain.filter(newExchange);
    };
  }
}