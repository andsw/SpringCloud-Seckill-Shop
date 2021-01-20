package cn.heshw.basegateway.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * 从gateway的配置中获取需要展示swagger文档的swaggerResources
 */
@Component
public class MySwaggerResourceProvider implements SwaggerResourcesProvider {

  /**
   * swagger2默认的url后缀
   */
  public static final String SWAGGER2URL = "/v2/api-docs";
  private final GatewayProperties gatewayProperties;

  public MySwaggerResourceProvider(GatewayProperties gatewayProperties) {
    this.gatewayProperties = gatewayProperties;
  }

  @Override
  public List<SwaggerResource> get() {
    List<SwaggerResource> resources = new ArrayList<>();
    gatewayProperties.getRoutes().stream()
        .filter(routeDefinition -> routeDefinition.getId().endsWith("-doc"))
        .forEach(routeDefinition -> resources.add(swaggerResource(routeDefinition.getId(),
            "/" + routeDefinition.getId() + SWAGGER2URL)));
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