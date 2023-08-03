package com.codingtest.rgt.account.controller;

import com.codingtest.rgt.account.controller.dto.response.LoginResponse;
import com.codingtest.rgt.account.service.AccountService;
import com.codingtest.rgt.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;


    @GetMapping("/oauth2/callback/google")
    public CommonResponse<?> successGoogleLogin(@RequestParam("code") String code) {
        var row = accountService.getGoogleAccount(code);

        // 필요하다면 DB에 유저정보 저장하는 로직 추가

        return CommonResponse.success(new LoginResponse(row));
    }


}
