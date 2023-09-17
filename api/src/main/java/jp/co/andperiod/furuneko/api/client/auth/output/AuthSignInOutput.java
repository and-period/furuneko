package jp.co.andperiod.furuneko.api.client.auth.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import jp.co.andperiod.furuneko.api.client.auth.AuthBaseResponse;
import lombok.Getter;

@Getter
public class AuthSignInOutput extends AuthBaseResponse {
  @JsonProperty("auth")
  private AuthOutput auth;
}
