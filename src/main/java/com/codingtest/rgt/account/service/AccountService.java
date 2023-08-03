package com.codingtest.rgt.account.service;

import com.codingtest.rgt.account.model.social.google.GoogleAccount;

public interface AccountService {

    GoogleAccount getGoogleAccount(String code);
}
