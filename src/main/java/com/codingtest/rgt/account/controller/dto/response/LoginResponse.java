package com.codingtest.rgt.account.controller.dto.response;

import com.codingtest.rgt.account.model.social.google.GoogleAccount;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

    private final GoogleAccount row;

    public LoginResponse(GoogleAccount row) {
        this.row = row;
    }

    @JsonProperty
    public String getAccessToken() {
        return row.getAccessToken();
    }

    @JsonProperty
    public String getEmail() {
        return row.getEmail();
    }

    @JsonProperty
    public String getName() {
        return row.getName();
    }

    @JsonProperty
    public String getPicture() {
        return row.getPicture();
    }

    @JsonProperty
    public String getExp() {
        return row.getExp();
    }

    @JsonProperty
    public String getLat() {
        return row.getLat();
    }
}
