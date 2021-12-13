package cn.heshw.baseauth.config;

import com.netflix.hystrix.exception.HystrixRuntimeException;
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
    if (e instanceof HystrixRuntimeException) {
      return ResponseEntity.status(500).body(
          ((HystrixRuntimeException) e).getFallbackException().getCause().getCause().getMessage());
    }
    return ResponseEntity.status(500).body(e.getMessage());
  }

}