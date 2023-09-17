package jp.co.andperiod.furuneko.api.client.auth.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthOutput {
  @JsonProperty("adminId")
  private String adminId;

  @JsonProperty("accessToken")
  private String accessToken;

  @JsonProperty("refreshToken")
  private String refreshToken;

  @JsonProperty("expiresIn")
  private Integer expiresIn;
}
