package cn.heshw.feign.fallback;

import cn.heshw.entity.User;
import cn.heshw.feign.FeignUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceFallback implements FeignUserService {

  // TODO：抛异常不是合适的处理方法，后续再思考
  @Override
  public User getAccount(String username) {
    log.error("can't get account with username: {}, please check shop-business-user module",
        username);
    return null;
  }

  @Override
  public Integer saveAccount(User user) {
    log.error("can't register, please check shop-business-user module!");
    return null;
  }
}