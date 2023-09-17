package jp.co.andperiod.furuneko.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.andperiod.furuneko.api.client.auth.AuthClient;
import jp.co.andperiod.furuneko.api.client.auth.output.AuthSignInOutput;
import jp.co.andperiod.furuneko.api.model.Auth;
import jp.co.andperiod.furuneko.api.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
  @Autowired
  private AuthClient authClient;

  @Override
  public Auth signIn(String key, String password) throws Exception {
    try {
      AuthSignInOutput out = authClient.signIn(key, password);
      if (out == null) {
        return null;
      }
      Auth auth = new Auth();
      auth.setAdminId(out.getAuth().getAdminId());
      auth.setAccessToken(out.getAuth().getAccessToken());
      auth.setRefreshToken(out.getAuth().getRefreshToken());
      auth.setExpiresIn(out.getAuth().getExpiresIn());
      return auth;
    } catch (Exception e) {
      throw e;
    }
  }
}
