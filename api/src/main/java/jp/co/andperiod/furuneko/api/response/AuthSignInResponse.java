package jp.co.andperiod.furuneko.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import jp.co.andperiod.furuneko.api.model.Auth;
import lombok.Data;

@Data
public class AuthSignInResponse {
  @JsonProperty("auth")
  private AuthResponse auth;

  public AuthSignInResponse(Auth auth) {
    this.auth = new AuthResponse(auth);
  }
}
