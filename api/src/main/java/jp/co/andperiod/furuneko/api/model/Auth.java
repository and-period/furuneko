package jp.co.andperiod.furuneko.api.model;

import lombok.Data;

@Data
public class Auth {
  private String adminId;
  private String accessToken;
  private String refreshToken;
  private Integer expiresIn;
}
