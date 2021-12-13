package cn.heshw.feign;

import cn.heshw.dto.AccountDTO;
import cn.heshw.exception.LoginException;
import cn.heshw.feign.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "business-user", fallback = UserServiceFallback.class)
@Component
public interface FeignUserService {

  @GetMapping(value = "/users")
  AccountDTO getAccount(@RequestParam String username) throws LoginException;


  @PostMapping(value = "/users")
  void saveAccount(@RequestBody AccountDTO account) throws LoginException;

}