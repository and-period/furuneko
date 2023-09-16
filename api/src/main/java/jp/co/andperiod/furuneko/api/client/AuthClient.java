package jp.co.andperiod.furuneko.api.client;

import jp.co.andperiod.furuneko.api.client.auth.dto.AuthDto;

// 認証サービスの呼び出し用HTTPクライアント
public interface AuthClient {
  /**
   * サインイン
   * @param key メールアドレス
   * @param password パスワード
   * @return {@link AuthDto} 認証情報
   * @throws Exception
   */
  public abstract AuthDto signIn(String key, String password) throws Exception;
}
