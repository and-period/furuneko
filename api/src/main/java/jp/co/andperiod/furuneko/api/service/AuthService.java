package jp.co.andperiod.furuneko.api.service;

import jp.co.andperiod.furuneko.api.model.Auth;

public interface AuthService {
  /**
   * サインイン
   * @param key メールアドレス
   * @param password パスワード
   * @return {@link Auth} 認証情報
   * @throws Exception
   */
  public abstract Auth signIn(String key, String password) throws Exception;
}
