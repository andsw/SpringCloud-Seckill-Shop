package cn.heshw.config;


import cn.heshw.uuid.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowiredConfiguration {

  @Bean
  public UUID uuid() {
    return new UUID();
  }
}