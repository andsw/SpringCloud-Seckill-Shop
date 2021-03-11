package cn.heshw.feign;

import cn.heshw.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "business-user")
public interface FeignUserService {

  @GetMapping(value = "/users")
  User getAccount(@RequestParam String username);


  @PostMapping(value = "/users")
  void saveAccount(@RequestBody User user);

}