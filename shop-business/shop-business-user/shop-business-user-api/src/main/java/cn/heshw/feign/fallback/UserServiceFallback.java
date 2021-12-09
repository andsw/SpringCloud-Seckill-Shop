package cn.heshw.feign.fallback;

import cn.heshw.dto.AccountDTO;
import cn.heshw.exception.LoginException;
import cn.heshw.feign.FeignUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceFallback implements FeignUserService {

  // TODO：抛异常不是合适的处理方法，后续再思考
  @Override
  public AccountDTO getAccount(String username) {
    log.error("can't get account with username: {}, please check shop-business-user module",
        username);
    return null;
  }

  @Override
  public void saveAccount(AccountDTO account) {
    log.error("can't register, please check shop-business-user module!");
    throw new LoginException("注册失败！");
  }
}