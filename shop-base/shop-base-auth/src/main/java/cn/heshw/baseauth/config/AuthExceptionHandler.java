package cn.heshw.baseauth.config;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<String> handleException(Exception e) {
    if (e instanceof FeignException) {
      String[] msgBody = e.getMessage().split(": ");
      return ResponseEntity.status(500)
          .body(msgBody[msgBody.length - 1]);
    }
    return ResponseEntity.status(500).body(e.getMessage());
  }

}