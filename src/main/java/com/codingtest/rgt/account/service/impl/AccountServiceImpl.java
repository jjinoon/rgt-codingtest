package com.codingtest.rgt.account.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.codingtest.rgt.account.model.social.google.GoogleAccount;
import com.codingtest.rgt.account.service.AccountService;
import com.codingtest.rgt.account.service.social.google.GoogleApi;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.StringReader;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final GoogleApi googleApi;

    @Override
    public GoogleAccount getGoogleAccount(String code) {
        String jsonResponse = googleApi.getAccessToken(code).join();
        try (JsonReader reader = Json.createReader(new StringReader(jsonResponse))) {
            JsonObject jsonObject = reader.readObject();
            String idToken = jsonObject.getString("id_token");

            DecodedJWT jwt = JWT.decode(idToken);

            return GoogleAccount.builder()
                    .accessToken(jsonObject.getString("access_token"))
                    .email(jwt.getClaim("email").asString())
                    .name(jwt.getClaim("name").asString())
                    .picture(jwt.getClaim("picture").asString())
                    .exp(jwt.getClaim("exp").asString())
                    .lat(jwt.getClaim("iat").asString())
                    .build();
        }
    }

}
