package jp.co.andperiod.furuneko.api.client.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import jp.co.andperiod.furuneko.api.client.AuthClient;
import jp.co.andperiod.furuneko.api.client.auth.dto.AuthDto;
import jp.co.andperiod.furuneko.api.client.auth.request.AuthSignInRequest;
import jp.co.andperiod.furuneko.api.client.auth.response.AuthSignInResponse;

@Component
public class AuthClientImpl implements AuthClient {
  private RestTemplate restTemplate = new RestTemplate();

  @Value("${client.auth.base-url}")
  private String baseUrl;

  @Override
  public AuthDto signIn(String key, String password) throws Exception {
    String url = baseUrl + "/admin/auth";
    AuthSignInRequest req = new AuthSignInRequest(key, password);

    try {
      AuthSignInResponse res = restTemplate.postForObject(url, req, AuthSignInResponse.class);
      if (res == null) {
        return null;
      }
      return res.getAuth();
    } catch (Exception e) {
      throw e;
    }
  }
}
