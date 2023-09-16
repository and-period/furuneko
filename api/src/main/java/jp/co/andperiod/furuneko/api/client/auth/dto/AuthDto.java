package jp.co.andperiod.furuneko.api.client.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthDto {
  @JsonProperty("adminId")
  private String adminId;

  @JsonProperty("accessToken")
  private String accessToken;

  @JsonProperty("refreshToken")
  private String refreshToken;

  @JsonProperty("expiresIn")
  private Integer expiresIn;
}
