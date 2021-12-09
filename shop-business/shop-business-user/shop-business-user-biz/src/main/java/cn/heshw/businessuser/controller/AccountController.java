package cn.heshw.businessuser.controller;

import static cn.heshw.businessuser.controller.DTOAssembler.toDTO;

import cn.heshw.businessuser.domain.aggregate.Account;
import cn.heshw.businessuser.infrastructure.repository.AccountRepository;
import cn.heshw.dto.AccountDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AccountController {
  private final AccountRepository accountRepository;

  @Autowired
  public AccountController(
      AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping
  public AccountDTO getAccount(@RequestParam String username) {
    Account account = accountRepository.findByName(username);
    return toDTO(account);
  }

  @PostMapping
  public void saveAccount(@RequestBody AccountDTO account) {
    Account newAccount = Account.builder().name(account.getUsername())
        .password(account.getPassword()).roles(account.getRoles()).build();
    accountRepository.save(newAccount);
  }
}