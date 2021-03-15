package cn.heshw.feign;

import cn.heshw.entity.User;
import cn.heshw.feign.fallback.UserServiceFallback;
import javax.security.auth.login.LoginException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "business-user", fallback = UserServiceFallback.class)
public interface FeignUserService {

  @GetMapping(value = "/users")
  User getAccount(@RequestParam String username) throws LoginException;


  @PostMapping(value = "/users")
  void saveAccount(@RequestBody User user) throws LoginException;

}