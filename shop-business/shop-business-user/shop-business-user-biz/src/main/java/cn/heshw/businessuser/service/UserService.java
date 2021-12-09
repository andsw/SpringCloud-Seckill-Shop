package cn.heshw.businessuser.service;

import cn.heshw.entity.User;

@Deprecated
public interface UserService {

  User getUserByName(String username);

  Integer saveUser(User user);
}