package cn.heshw.businessuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopBusinessUserApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopBusinessUserApplication.class, args);
  }
}