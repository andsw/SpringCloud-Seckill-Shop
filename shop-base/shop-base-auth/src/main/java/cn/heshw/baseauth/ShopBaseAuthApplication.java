package cn.heshw.baseauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"cn.heshw"})
@EnableDiscoveryClient
public class ShopBaseAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopBaseAuthApplication.class, args);
  }
}