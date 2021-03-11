package cn.heshw.businessuser.config;

import cn.heshw.exception.LoginException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<String> handleException(Exception e) {
    if (e instanceof DuplicateKeyException) {
      return ResponseEntity.status(500).body("此用户名已存在，请更换用户名再注册！");
    } else {
      return ResponseEntity.status(500).body(e.getMessage());
    }
  }

}