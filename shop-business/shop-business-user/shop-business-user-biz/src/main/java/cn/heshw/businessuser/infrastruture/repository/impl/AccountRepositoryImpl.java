package cn.heshw.businessuser.infrastruture.repository.impl;

import static cn.heshw.businessuser.infrastruture.DataConverter.toDO;
import static cn.heshw.businessuser.infrastruture.DataConverter.toEntity;
import static cn.heshw.constant.EntityIDPrefix.USER;
import static org.springframework.util.CollectionUtils.firstElement;

import cn.heshw.businessuser.domain.aggregate.Account;
import cn.heshw.businessuser.infrastruture.mapper.UserMapper;
import cn.heshw.businessuser.infrastruture.repository.AccountRepository;
import cn.heshw.entity.User;
import cn.heshw.entity.UserExample;
import cn.heshw.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

  private final UserMapper userMapper;
  private final UUID uuid;

  @Autowired
  public AccountRepositoryImpl(UserMapper userMapper, UUID uuid) {
    this.userMapper = userMapper;
    this.uuid = uuid;
  }

  @Override
  public Account find(String entityId) {
    UserExample example = userUidEqual(entityId);
    return toEntity(firstElement(userMapper.selectByExample(example)));
  }

  @Override
  public Account findByName(String username) {
    UserExample example = new UserExample();
    example.createCriteria().andUsernameEqualTo(username);
    return toEntity(firstElement(userMapper.selectByExample(example)));
  }

  @Override
  public void save(Account domain) {
    if (domain.identityId() == null) {
      User user = toDO(domain);
      user.setUserUid(uuid.generateIdFor(USER));
      userMapper.insert(user);
    } else {
      userMapper.updateByExampleSelective(toDO(domain), userUidEqual(domain.identityId()));
    }
  }

  @Override
  public void remove(String entityId) {
    userMapper.deleteByExample(userUidEqual(entityId));
  }

  private UserExample userUidEqual(String userUid) {
    UserExample example = new UserExample();
    example.createCriteria().andUserUidEqualTo(userUid);
    return example;
  }
}