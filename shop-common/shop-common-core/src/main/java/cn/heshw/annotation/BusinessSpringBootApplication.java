package cn.heshw.annotation;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hsw
 * @create 2021-01-17  21:46
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
@MapperScan(basePackages = {"cn.heshw.businessuser.mapper"})
public @interface BusinessSpringBootApplication {

}
