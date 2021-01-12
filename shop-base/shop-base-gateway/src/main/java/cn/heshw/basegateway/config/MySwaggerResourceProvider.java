package cn.heshw.basegateway.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
public class MySwaggerResourceProvider implements SwaggerResourcesProvider {

  /**
   * swagger2默认的url后缀
   */
  public static final String SWAGGER2URL = "/v2/api-docs";
  private final RouteLocator routeLocator;
  private final GatewayProperties gatewayProperties;

  public MySwaggerResourceProvider(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
    this.routeLocator = routeLocator;
    this.gatewayProperties=gatewayProperties;
  }

  @Override
  public List<SwaggerResource> get() {
    List<SwaggerResource> resources = new ArrayList<>();
    List<String> routes = new ArrayList<>();
    routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
    gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
        .filter(routeDefinition -> routeDefinition.getId().endsWith("-doc"))
        .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
            .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
            .forEach(predicateDefinition -> resources.add(swaggerResource(routeDefinition.getId(),
                "/"+routeDefinition.getId()+SWAGGER2URL))));
    return resources;
  }

  private SwaggerResource swaggerResource(String name, String location) {
    SwaggerResource swaggerResource = new SwaggerResource();
    swaggerResource.setName(name);
    swaggerResource.setLocation(location);
    swaggerResource.setSwaggerVersion("2.0");
    return swaggerResource;
  }

}