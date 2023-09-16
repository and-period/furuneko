package jp.co.andperiod.furuneko.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthSignInRequest {
  @JsonProperty("key")
  private String key;

  @JsonProperty("password")
  private String password;
}
