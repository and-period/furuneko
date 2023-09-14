package jp.co.andperiod.furuneko.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HelloResponse {
  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("message")
  private String message;

  @JsonCreator
  public HelloResponse(int id, String lastname, String firstname, String message) {
    this.id = id;
    this.name = lastname + firstname;
    this.message = message;
  }
}
