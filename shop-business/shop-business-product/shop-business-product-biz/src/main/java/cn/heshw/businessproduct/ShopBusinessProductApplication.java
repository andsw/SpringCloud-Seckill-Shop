package cn.heshw.businessproduct;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
@MapperScan(basePackages = {"cn.heshw.businessuser.mapper"})
public class ShopBusinessProductApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopBusinessProductApplication.class, args);
  }
}