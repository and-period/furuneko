package jp.co.andperiod.furuneko.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.andperiod.furuneko.api.response.HealthResponse;

@Controller
public class HealthController {
  @GetMapping(path="/health")
  public ResponseEntity<HealthResponse> health() throws Exception {
    HealthResponse res = new HealthResponse("ok");
    return ResponseEntity.ok().body(res);
  }
}
