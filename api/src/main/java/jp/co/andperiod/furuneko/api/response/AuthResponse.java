package jp.co.andperiod.furuneko.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import jp.co.andperiod.furuneko.api.model.Auth;
import lombok.Data;

@Data
public class AuthResponse {
  @JsonProperty("adminId")
  private String adminId;

  @JsonProperty("accessToken")
  private String accessToken;

  @JsonProperty("refreshToken")
  private String refreshToken;

  @JsonProperty("expiresIn")
  private Integer expiresIn;

  public AuthResponse(Auth auth) {
    this.adminId = auth.getAdminId();
    this.accessToken = auth.getAccessToken();
    this.refreshToken = auth.getRefreshToken();
    this.expiresIn = auth.getExpiresIn();
  }
}
