package jp.co.andperiod.furuneko.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.andperiod.furuneko.api.request.HelloRequest;
import jp.co.andperiod.furuneko.api.response.HelloResponse;

@RestController
public class HelloController {
  @PostMapping(path="/hello")
  public ResponseEntity<HelloResponse> hello(@RequestBody @Validated HelloRequest req, BindingResult rs) {
    if (rs.hasErrors()) {
      List<String> errs = new ArrayList<String>();
      for (ObjectError error : rs.getAllErrors()) {
        errs.add(error.getDefaultMessage());
      }
      HelloResponse res = new HelloResponse(0, "", "", errs.toString());
      return ResponseEntity.badRequest().body(res);
    }

    HelloResponse res = new HelloResponse(1, req.getLastname(), req.getFirstname(), "Hello, World!");
    return ResponseEntity.ok().body(res);
  }
}
