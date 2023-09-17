package jp.co.andperiod.furuneko.api.client.auth;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import jp.co.andperiod.furuneko.api.client.auth.input.AuthSignInInput;
import jp.co.andperiod.furuneko.api.client.auth.output.AuthOutput;
import jp.co.andperiod.furuneko.api.client.auth.output.AuthSignInOutput;

// 認証サービスの呼び出し用HTTPクライアント
@Component
public class AuthClient extends AuthBaseClient {
  /**
   * サインイン
   * @param key メールアドレス
   * @param password パスワード
   * @return {@link AuthOutput} 認証情報
   * @throws Exception
   */
  public AuthSignInOutput signIn(String key, String password) {
    String url = getBaseUrl()+"/admin/auth";
    AuthSignInInput body = new AuthSignInInput(key, password);
    RequestEntity<AuthSignInInput> req = RequestEntity
      .post(url)
      .accept(MediaType.APPLICATION_JSON)
      .body(body);

    RestTemplate restTemplate = getRestTemplate();
    ResponseEntity<AuthSignInOutput> res = restTemplate.exchange(req, AuthSignInOutput.class);
    return res.getBody();
  }
}
