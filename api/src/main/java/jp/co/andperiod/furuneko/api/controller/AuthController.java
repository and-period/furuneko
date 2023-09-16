package jp.co.andperiod.furuneko.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jp.co.andperiod.furuneko.api.request.AuthSignInRequest;
import jp.co.andperiod.furuneko.api.response.AuthSignInResponse;
import jp.co.andperiod.furuneko.api.model.Auth;
import jp.co.andperiod.furuneko.api.service.impl.AuthServiceImpl;

@Controller
public class AuthController {
  @Autowired
  private AuthServiceImpl authService;

  @PostMapping(path="/auth")
  public ResponseEntity<AuthSignInResponse> signIn(@RequestBody @Validated AuthSignInRequest req, BindingResult rs) {
    if (rs.hasErrors()) {
      List<String> errs = new ArrayList<String>();
      for (ObjectError error : rs.getAllErrors()) {
        errs.add(error.getDefaultMessage());
      }
      return ResponseEntity.badRequest().body(null);
    }

    try {
      Auth auth = authService.signIn(req.getKey(), req.getPassword());

      AuthSignInResponse res = new AuthSignInResponse(auth);
      return ResponseEntity.ok().body(res);
    } catch (Exception e) {
      System.out.printf("debug:failed to signin service: %s", e.toString());
      return ResponseEntity.badRequest().body(null);
    }
  }
}
