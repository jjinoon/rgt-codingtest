package com.codingtest.rgt.account.model.social.google;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GoogleAccount {

    private String accessToken;
    private String email;
    private String name;
    private String picture;
    private String exp;
    private String lat;
}
