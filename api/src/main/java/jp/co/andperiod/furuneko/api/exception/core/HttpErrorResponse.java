package jp.co.andperiod.furuneko.api.exception.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HttpErrorResponse {
  @JsonProperty("status")
  private int status;

  @JsonProperty("message")
  private String message;

  @JsonProperty("detail")
  private String detail;

  public HttpErrorResponse(HttpException httpException) {
    this.status = httpException.getHttpStatus();
    this.message = httpException.getHttpCode();
    this.detail = httpException.toString();
  }

  public HttpErrorResponse(HttpException httpException, String detail) {
    this.status = httpException.getHttpStatus();
    this.message = httpException.getHttpCode();
    this.detail = detail;
  }
}
