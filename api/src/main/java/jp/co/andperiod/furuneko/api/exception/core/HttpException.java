package jp.co.andperiod.furuneko.api.exception.core;

import java.util.ArrayList;
import java.util.List;

public class HttpException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private HttpErrorCode code;
  private List<String> messages = new ArrayList<>();

  public HttpException(HttpErrorCode httpErrorCode) {
    this.code = httpErrorCode;
  }

  public HttpException(HttpErrorCode httpErrorCode, String message) {
    this.code = httpErrorCode;
    this.messages.add(message);
  }

  public HttpException(HttpErrorCode httpErrorCode, List<String> messages) {
    this.code = httpErrorCode;
    messages.forEach(s -> this.messages.add(s));
  }

  public int getHttpStatus() {
    return this.code.getHttpStatus().value();
  }

  public String getHttpCode() {
    return this.code.getHttpStatus().getReasonPhrase();
  }

  public String toString() {
    switch (this.messages.size()) {
    case 0:
      return "";
    case 1:
      return this.messages.get(0);
    default:
      return this.messages.toString();
    }
  }
}
