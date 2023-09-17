package jp.co.andperiod.furuneko.api.client.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthBaseResponse {
  @JsonProperty("status")
  private Integer status;

  @JsonProperty("message")
  private String message;

  @JsonProperty("detail")
  private String detail;
}
