package jp.co.andperiod.furuneko.api.client.auth.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthSignInInput {
  @JsonProperty("key")
  private String key;

  @JsonProperty("password")
  private String password;

  public AuthSignInInput(String key, String password) {
    this.key = key;
    this.password = password;
  }
}
