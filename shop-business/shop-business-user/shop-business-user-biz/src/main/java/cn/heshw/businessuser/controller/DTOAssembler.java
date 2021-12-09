package cn.heshw.businessuser.controller;

import cn.heshw.businessuser.domain.aggregate.Account;
import cn.heshw.dto.AccountDTO;

public class DTOAssembler {

  public static AccountDTO toDTO(Account account) {
    AccountDTO dto = new AccountDTO();
    dto.setUserUid(account.identityId());
    dto.setUsername(account.getName());
    dto.setPassword(account.getPassword());
    return dto;
  }

}