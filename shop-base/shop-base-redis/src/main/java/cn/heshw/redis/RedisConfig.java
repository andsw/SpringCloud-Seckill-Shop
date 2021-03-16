package cn.heshw.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class RedisConfig extends JCacheConfigurerSupport {

  @Bean
  public KeyGenerator keyGenerator() {
    return (target, method, params) -> {
      StringBuilder sb = new StringBuilder();
      sb.append(target.getClass().getName()).append(method.getName());
      for (Object param : params) {
        sb.append(param);
      }
      return sb.toString();
    };
  }

}