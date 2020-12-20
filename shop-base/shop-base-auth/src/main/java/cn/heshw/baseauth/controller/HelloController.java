package cn.heshw.baseauth.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
//
//  @Value(value = "${name}")
//  private String moduleName;
//
//  public void setModuleName(String moduleName) {
//    this.moduleName = moduleName;
//  }

  @GetMapping(value = "/auth/hello")
  public String hello() {
    return "hello";
  }
}