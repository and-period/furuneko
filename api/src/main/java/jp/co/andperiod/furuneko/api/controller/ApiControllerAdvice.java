package jp.co.andperiod.furuneko.api.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jp.co.andperiod.furuneko.api.exception.core.HttpErrorResponse;
import jp.co.andperiod.furuneko.api.exception.core.HttpException;

@RestControllerAdvice
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {
  @ExceptionHandler(HttpException.class)
  public ResponseEntity<HttpErrorResponse> handleException(HttpException e) {
    HttpErrorResponse res = new HttpErrorResponse(e, e.toString());
    return new ResponseEntity<HttpErrorResponse>(res, new HttpHeaders(), e.getHttpStatus());
  }
}
