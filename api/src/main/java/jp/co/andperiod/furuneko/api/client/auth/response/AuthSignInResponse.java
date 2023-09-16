package jp.co.andperiod.furuneko.api.client.auth.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import jp.co.andperiod.furuneko.api.client.auth.dto.AuthDto;
import lombok.Data;

@Data
public class AuthSignInResponse {
  @JsonProperty("auth")
  private AuthDto auth;
}
