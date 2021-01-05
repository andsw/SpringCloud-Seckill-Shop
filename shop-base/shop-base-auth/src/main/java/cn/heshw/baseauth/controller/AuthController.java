package cn.heshw.baseauth.controller;

import cn.heshw.auth.JWTUtil;
import cn.heshw.dto.LoginDTO;
import cn.heshw.exception.LoginException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

  private static final String AUTHORIZATION_HEADER = "Authorization";

  @PostMapping(value = "/login")
  public void login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {
    String password = "123456";
    if (password.equals(loginDTO.getPassword())) {
      String token;
      try {
        token = JWTUtil.generateToken(loginDTO.getUsername(), "super");
      } catch (Exception e) {
        throw new LoginException("token生成失败");
      }
      response.addHeader(AUTHORIZATION_HEADER, token);
    } else {
      throw new LoginException("密码错误");
    }
  }
}