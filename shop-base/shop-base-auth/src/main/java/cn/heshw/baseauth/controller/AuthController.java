package cn.heshw.baseauth.controller;

import static cn.heshw.baseauth.util.EncodeUtil.encode;
import static org.apache.commons.lang3.StringUtils.isBlank;

import cn.heshw.auth.JWTUtil;
import cn.heshw.baseauth.dto.LoginDTO;
import cn.heshw.entity.User;
import cn.heshw.exception.LoginException;
import cn.heshw.feign.FeignUserService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

  private static final String AUTHORIZATION_HEADER = "Authorization";

  private final FeignUserService feignUserService;

  @Autowired
  public AuthController(FeignUserService feignUserService) {
    this.feignUserService = feignUserService;
  }

  @PostMapping(value = "/login")
  public void login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws Exception {
    checkAccountValid(loginDTO.getUsername(), loginDTO.getPassword());
    final User user = feignUserService.getAccount(loginDTO.getUsername());
    if (user != null && encode(loginDTO.getPassword()).equals(user.getPassword())) {
      String token;
      token = JWTUtil.generateToken(loginDTO.getUsername(), "super");
      response.addHeader(AUTHORIZATION_HEADER, token);
    } else {
      throw new LoginException("密码错误!");
    }
  }

  @PostMapping("/register")
  public void register(@RequestBody User user) {
    checkAccountValid(user.getUsername(), user.getPassword());
    user.setPassword(encode(user.getPassword()));
    feignUserService.saveAccount(user);
  }

  private void checkAccountValid(String username, String password) {
    if (isBlank(username) || isBlank(password)) {
      throw new IllegalArgumentException("账号和密码都不能为空!");
    }
  }
}