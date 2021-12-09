package cn.heshw.businessuser.infrastruture;

import cn.heshw.businessuser.domain.aggregate.Account;
import cn.heshw.entity.User;

public class DataConverter {

  public static Account toEntity(User user) {
    if (user == null) {
      return null;
    }
    return Account.builder().uid(user.getUserUid()).name(user.getUsername()).roles(user.getRole())
        .registerTime(user.getRegisterTime()).build();
  }

  public static User toDO(Account account) {
    User user = new User();
    user.setUserUid(account.identityId());
    user.setUsername(account.getName());
    user.setRole(String.join(",", account.getRoles()));
    user.setRegisterTime(account.getRegisterTime());
    user.setPassword(account.getPassword());
    return user;
  }
}