package cn.heshw.baseauth.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<String> handleException(Exception e) {
    return ResponseEntity.status(500).body(e.getMessage());
  }

}