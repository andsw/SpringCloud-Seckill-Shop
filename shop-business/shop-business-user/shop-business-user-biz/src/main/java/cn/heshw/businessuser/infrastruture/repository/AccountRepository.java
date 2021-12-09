package cn.heshw.businessuser.infrastruture.repository;

import cn.heshw.businessuser.domain.aggregate.Account;
import cn.heshw.ddd.Repository;

public interface AccountRepository extends Repository<Account> {

  Account findByName(String username);
}