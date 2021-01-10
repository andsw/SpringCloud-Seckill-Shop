package cn.heshw.businessuser.controller;

import cn.heshw.businessuser.service.UserService;
import cn.heshw.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public User getAccount(@RequestParam String username) {
    return userService.getUserByName(username);
  }

  @PostMapping
  public void saveAccount(@RequestBody User user) {
    userService.saveUser(user);
  }
}