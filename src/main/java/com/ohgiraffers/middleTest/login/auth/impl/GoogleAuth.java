package com.ohgiraffers.middleTest.login.auth.impl;

import com.ohgiraffers.middleTest.login.auth.SnsAuth;
import com.ohgiraffers.middleTest.login.dto.MemberDTO;

public class GoogleAuth implements SnsAuth {

    @Override
    public boolean login(MemberDTO member) {
        System.out.println("구글 로그인 성공됨");
        return true;
    }
}
