package cn.heshw.businessuser.service.impl;

import cn.heshw.entity.User;
import cn.heshw.entity.UserExample;
import cn.heshw.businessuser.infrastructure.mapper.UserMapper;
import cn.heshw.businessuser.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Deprecated
@Service
@CacheConfig(cacheNames = {"UserCache"})
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  @Autowired
  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  @Cacheable(cacheNames = {"user"}, key="#username")
  public User getUserByName(String username) {
    UserExample example = new UserExample();
    example.createCriteria().andUsernameEqualTo(username);
    final List<User> users = userMapper.selectByExample(example);
    return CollectionUtils.firstElement(users);
  }

  @Override
  public Integer saveUser(User user) {
    return userMapper.insertSelective(user);
  }
}