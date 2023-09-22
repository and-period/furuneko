package jp.co.andperiod.furuneko.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HealthResponse {
  @JsonProperty("message")
  private String message;

  public HealthResponse(String message) {
    this.message = message;
  }
}
