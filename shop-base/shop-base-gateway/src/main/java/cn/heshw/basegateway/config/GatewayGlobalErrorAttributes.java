package cn.heshw.basegateway.config;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import cn.heshw.exception.LoginException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.annotation.MergedAnnotations.SearchStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;

@Component
public class GatewayGlobalErrorAttributes implements ErrorAttributes {

  private static final String ERROR_ATTRIBUTE = GatewayGlobalErrorAttributes.class.getName() + ".ERROR";

  @Override
  public Map<String, Object> getErrorAttributes(ServerRequest request,
      ErrorAttributeOptions options) {
    Map<String, Object> errorAttributes = new LinkedHashMap<>();
    Throwable error = this.getError(request);
    MergedAnnotation<ResponseStatus> responseStatusAnnotation = MergedAnnotations
        .from(error.getClass(), SearchStrategy.TYPE_HIERARCHY).get(ResponseStatus.class);
    HttpStatus errorStatus = this.determineHttpStatus(error, responseStatusAnnotation);
    errorAttributes.put("status", errorStatus.value());
    if (error instanceof LoginException) {
      errorAttributes.put("error", errorStatus.getReasonPhrase());
      errorAttributes.put("message", this.determineMessage(error, responseStatusAnnotation));
    } else {
      this.handleException(errorAttributes, this.determineException(error), options.isIncluded(Include.STACK_TRACE));
    }
    return errorAttributes;
  }

  @Override
  public Throwable getError(ServerRequest request) {
    return (Throwable)request.attribute(ERROR_ATTRIBUTE).orElseThrow(() -> new IllegalStateException("未知错误"));
  }

  @Override
  public void storeErrorInformation(Throwable error, ServerWebExchange exchange) {
    exchange.getAttributes().putIfAbsent(ERROR_ATTRIBUTE, error);
  }

  private HttpStatus determineHttpStatus(Throwable error, MergedAnnotation<ResponseStatus> responseStatusAnnotation) {
    return error instanceof ResponseStatusException ? ((ResponseStatusException)error).getStatus() : responseStatusAnnotation.getValue("code", HttpStatus.class).orElse(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private String determineMessage(Throwable error, MergedAnnotation<ResponseStatus> responseStatusAnnotation) {
    if (error instanceof BindingResult) {
      return error.getMessage();
    } else if (error instanceof ResponseStatusException) {
      return ((ResponseStatusException)error).getReason();
    } else {
      String reason = (String)responseStatusAnnotation.getValue("reason", String.class).orElse("");
      if (StringUtils.hasText(reason)) {
        return reason;
      } else {
        return error.getMessage() != null ? error.getMessage() : "";
      }
    }
  }

  private Throwable determineException(Throwable error) {
    if (error instanceof ResponseStatusException) {
      return error.getCause() != null ? error.getCause() : error;
    } else {
      return error;
    }
  }

  private void handleException(Map<String, Object> errorAttributes, Throwable error, boolean includeStackTrace) {
    errorAttributes.put("exception", error.getClass().getName());
    if (includeStackTrace) {
      this.addStackTrace(errorAttributes, error);
    }

    if (error instanceof BindingResult) {
      BindingResult result = (BindingResult)error;
      if (result.hasErrors()) {
        errorAttributes.put("errors", result.getAllErrors());
      }
    }

  }

  private void addStackTrace(Map<String, Object> errorAttributes, Throwable error) {
    StringWriter stackTrace = new StringWriter();
    error.printStackTrace(new PrintWriter(stackTrace));
    stackTrace.flush();
    errorAttributes.put("trace", stackTrace.toString());
  }
}