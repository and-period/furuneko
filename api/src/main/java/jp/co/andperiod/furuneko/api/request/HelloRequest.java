package jp.co.andperiod.furuneko.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HelloRequest {
  @NotBlank
  @JsonProperty("lastname")
  private String lastname;

  @NotBlank
  @JsonProperty("firstname")
  private String firstname;
}
