package cn.heshw.basegateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class GatewayController {

  @GetMapping(value = "/gateway/hello")
  @ApiOperation(value = "hello")
  public String hello() {
    return "hello from gateway";
  }

}