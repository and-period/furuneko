package jp.co.andperiod.furuneko.api.client.auth;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.andperiod.furuneko.api.exception.GeneralHttpErrorCode;
import jp.co.andperiod.furuneko.api.exception.core.HttpErrorCode;
import jp.co.andperiod.furuneko.api.exception.core.HttpException;

@Component
public class AuthBaseClient {
  private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(3);
  protected Duration CONNECT_TIMEOUT;
  protected Duration REQUEST_TIMEOUT;

  @Value("${client.auth.base-url}")
  private String BASE_URL;

  /**
   * HTTPクライアント（タイムアウト指定）
   * @param connectTimeout 接続タイムアウト
   * @param requestTimeout リクエストタイムアウト
   * @return
   */
  protected RestTemplate getRestTemplate(Duration connectTimeout, Duration requestTimeout) {
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    factory.setConnectTimeout(connectTimeout);
    factory.setConnectionRequestTimeout(requestTimeout);

    RestTemplate restTemplate = new RestTemplate(factory);
    restTemplate.setErrorHandler(new AuthResponseErrorHandler());
    return restTemplate;
  }

  /**
   * HTTPクライアント
   * @return
   */
  protected RestTemplate getRestTemplate() {
    return getRestTemplate(DEFAULT_TIMEOUT, DEFAULT_TIMEOUT);
  }

  /**
   * 認証サービスの接続先ベースURLを取得
   * @return
   */
  protected String getBaseUrl() {
    return this.BASE_URL;
  }

  /**
   * 認証サービスのエラーハンドラ
   * ・4xx：レスポンスを取得できるように
   * ・5xx：Exceptionにカスタマイズ
   */
  private static class AuthResponseErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse res) throws IOException {
      try {
        HttpStatusCode code = res.getStatusCode();
        if (code.is2xxSuccessful()) {
          return;
        }

        String buf = StreamUtils.copyToString(res.getBody(), Charset.defaultCharset());
        AuthBaseResponse out = new ObjectMapper().readValue(buf, AuthBaseResponse.class);
        HttpErrorCode httpErrorCode = getHttpErrorCode(res.getStatusCode().value());

        throw new HttpException(httpErrorCode, out.getDetail());
      } catch (IllegalArgumentException e) {
        throw new RestClientException(String.format("unknown status code: %s", res.getStatusCode()));
      }
    }
  }

  private static HttpErrorCode getHttpErrorCode(int status) {
    switch (status) {
      case 400:
        return GeneralHttpErrorCode.BAD_REQUEST;
      case 401:
        return GeneralHttpErrorCode.UNAUTHORIZED;
      case 403:
        return GeneralHttpErrorCode.FORBIDDEN;
      case 404:
        return GeneralHttpErrorCode.NOT_FOUND;
      case 409:
        return GeneralHttpErrorCode.CONFLICT;
      case 412:
        return GeneralHttpErrorCode.PRECONDITION_FAILED;
      case 429:
        return GeneralHttpErrorCode.TOO_MANY_REQUESTS;
      default:
        return GeneralHttpErrorCode.INTERNAL_SERVER_ERROR;
      }
  }
}
