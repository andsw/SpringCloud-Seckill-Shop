package cn.heshw.baseauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping(value = "/auth/hello")
  public String hello() {
    return "hello base-auth";
  }
}