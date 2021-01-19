package cn.heshw.businessorder;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
@MapperScan(basePackages = {"cn.heshw.businessuser.mapper"})
public class ShopBusinessOrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopBusinessOrderApplication.class, args);
  }
}