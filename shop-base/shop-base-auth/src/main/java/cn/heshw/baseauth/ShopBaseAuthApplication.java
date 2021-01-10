package cn.heshw.baseauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"cn.heshw"})
@EnableDiscoveryClient
@EnableFeignClients("cn.heshw.feign")
public class ShopBaseAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopBaseAuthApplication.class, args);
  }
}