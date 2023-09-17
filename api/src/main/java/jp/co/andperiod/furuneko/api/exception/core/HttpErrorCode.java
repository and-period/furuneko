package jp.co.andperiod.furuneko.api.exception.core;

import org.springframework.http.HttpStatus;

public interface HttpErrorCode {
  HttpStatus getHttpStatus();
}
