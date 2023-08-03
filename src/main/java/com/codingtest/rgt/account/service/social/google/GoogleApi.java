package com.codingtest.rgt.account.service.social.google;

import com.codingtest.rgt.common.exception.RgtException;
import com.codingtest.rgt.common.response.ErrorCode;
import com.linecorp.armeria.client.ResponseTimeoutException;
import com.linecorp.armeria.client.WebClient;
import com.linecorp.armeria.client.logging.LoggingClient;
import com.linecorp.armeria.client.retry.RetryRule;
import com.linecorp.armeria.client.retry.RetryingClient;
import com.linecorp.armeria.common.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class GoogleApi {

    WebClient webClient;

    @Value("${oauth2.google.client-id}")
    private String GOOGLE_CLIENT_ID;

    @Value("${oauth2.google.client-secret}")
    private String GOOGLE_CLIENT_SECRET;

    @Value("${oauth2.google.redirect-uri}")
    private String LOGIN_REDIRECT_URI;

    public GoogleApi() {
        this.webClient = newWebClient();
    }

    public CompletableFuture<String> getAccessToken(String code) {
        RequestHeaders headers = RequestHeaders.builder()
                .method(HttpMethod.POST)
                .path("/oauth2/v4/token")
                .scheme("https")
                .authority("www.googleapis.com")
                .contentType(MediaType.FORM_DATA)
                .build();

        String content = String.format("code=%s&client_id=%s&client_secret=%s&redirect_uri=%s&grant_type=authorization_code",
                code,
                GOOGLE_CLIENT_ID,
                GOOGLE_CLIENT_SECRET,
                LOGIN_REDIRECT_URI
        );

        HttpRequest request = HttpRequest.of(headers, HttpData.ofUtf8(content));

        return webClient.execute(request).aggregate()
                .thenApply(res -> {
                    if(res.status().isSuccess()) {
                        return res.contentUtf8();
                    } else {
                        throw new RgtException(ErrorCode.COMMON_SYSTEM_ERROR);
                    }
                });
    }


    private WebClient newWebClient() {
        RetryRule retryRule = RetryRule.of(
                RetryRule.builder().onUnprocessed().thenBackoff(),
                RetryRule.builder().onException(ResponseTimeoutException.class).thenBackoff(),
                RetryRule.builder().onStatus(HttpStatus.BAD_GATEWAY, HttpStatus.SERVICE_UNAVAILABLE, HttpStatus.GATEWAY_TIMEOUT).thenBackoff(),
                RetryRule.builder().onStatus(HttpStatus.TOO_MANY_REQUESTS).thenNoRetry()
        );

        return WebClient
                .builder(URI.create("https://www.googleapis.com"))
                .decorator(LoggingClient.newDecorator())
                .decorator(RetryingClient.builder(retryRule).newDecorator())
                .build();
    }

}