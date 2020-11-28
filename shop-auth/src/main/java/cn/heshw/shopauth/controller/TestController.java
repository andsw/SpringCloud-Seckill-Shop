package cn.heshw.shopauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping(value = "/hello")
  public String hello() {
    return "Hello API can be accessed!";
  }

}