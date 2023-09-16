package jp.co.andperiod.furuneko.api.client.auth.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthSignInRequest {
  @JsonProperty("key")
  private String key;

  @JsonProperty("password")
  private String password;

  public AuthSignInRequest(String key, String password) {
    this.key = key;
    this.password = password;
  }
}
