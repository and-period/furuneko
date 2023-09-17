package jp.co.andperiod.furuneko.api.exception;

import org.springframework.http.HttpStatus;

import jp.co.andperiod.furuneko.api.exception.core.HttpErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GeneralHttpErrorCode implements HttpErrorCode {
  /**
   * 4xx系
   */
  /* バリデーションエラー */
  BAD_REQUEST(HttpStatus.BAD_REQUEST, "BAD_REQUEST", ""),

  /* 認証エラー */
  UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", ""),

  /* 権限エラー */
  FORBIDDEN(HttpStatus.FORBIDDEN, "FORBIDDEN", ""),

  /* リソース未存在 */
  NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND", ""),

  /* リクエストタイムアウト */
  REQUEST_TIMEOUT(HttpStatus.REQUEST_TIMEOUT, "REQUEST_TIMEOUT", ""),

  /* 重複エラー */
  CONFLICT(HttpStatus.CONFLICT, "ALREADY_EXISTS", ""),

  /* 前提条件エラー */
  PRECONDITION_FAILED(HttpStatus.PRECONDITION_FAILED, "PRECONDITION_FAILED", ""),

  /* リクエスト超過 */
  TOO_MANY_REQUESTS(HttpStatus.TOO_MANY_REQUESTS, "TOO_MANY_REQUESTS", ""),

  /**
   * 5xx系
   */
  /* サーバーエラー */
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "");

  private final HttpStatus httpStatus;
  private final String code;
  private final String message;
}
