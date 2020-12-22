package cn.heshw.basegateway.config;

import cn.heshw.basegateway.filter.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

  private final AuthorizationFilter authorizationFilter;

  @Autowired
  public FilterConfig(
      AuthorizationFilter authorizationFilter) {
    this.authorizationFilter = authorizationFilter;
  }

  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder builder) {
    return builder.routes().route(r -> r.path("/**")
        .filters(f -> f.filter(authorizationFilter))
        .uri("localhost:88")
        .order(0)
        .id("ribbon-route")
    ).build();
  }
}