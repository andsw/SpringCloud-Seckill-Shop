package cn.heshw.basegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"cn.heshw"})
@EnableDiscoveryClient
public class ShopBaseGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopBaseGatewayApplication.class, args);
  }
}