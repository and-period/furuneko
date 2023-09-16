package jp.co.andperiod.furuneko.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.andperiod.furuneko.api.client.auth.AuthClientImpl;
import jp.co.andperiod.furuneko.api.client.auth.dto.AuthDto;
import jp.co.andperiod.furuneko.api.model.Auth;
import jp.co.andperiod.furuneko.api.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
  @Autowired
  private AuthClientImpl authClient;

  @Override
  public Auth signIn(String key, String password) throws Exception {
    try {
      AuthDto res = authClient.signIn(key, password);
      if (res == null) {
        return null;
      }
      Auth auth = new Auth();
      auth.setAdminId(res.getAdminId());
      auth.setAccessToken(res.getAccessToken());
      auth.setRefreshToken(res.getRefreshToken());
      auth.setExpiresIn(res.getExpiresIn());
      return auth;
    } catch (Exception e) {
      throw e;
    }
  }
}
