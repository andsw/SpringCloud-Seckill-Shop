package cn.heshw.feign.fallback;

import cn.heshw.entity.User;
import cn.heshw.feign.FeignUserService;
import javax.security.auth.login.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceFallback implements FeignUserService {

  // TODO：抛异常不是合适的处理方法，后续再思考
  @Override
  public User getAccount(String username) throws LoginException {
    log.error("can't get account with username: {}", username);
    throw new LoginException("用户模块不可用，无法获取账户信息！");
  }

  @Override
  public void saveAccount(User user) throws LoginException {
    log.error("can't register");
    throw new LoginException("用户模块不可用，无法注册！");
  }
}