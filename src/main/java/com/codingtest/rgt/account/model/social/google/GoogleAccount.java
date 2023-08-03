package com.codingtest.rgt.account.model.social;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;

public class GoogleAccount {

    @Getter
    String id;
    @Getter String email;
    @Getter String nickname;

    public GoogleAccount(String body) {
        if(StringUtils.isBlank(body)) throw new IllegalArgumentException("not exist google info");

        JSONObject json = new JSONObject(body);

        //회원번호
        this.id = json.optString("id");

        //이메일
        this.email = json.optString("email");

        //닉네임
        this.nickname = json.optString("name");
    }
}
