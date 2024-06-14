package com.ohgiraffers.middleTest.login.service;

import com.ohgiraffers.middleTest.login.auth.SnsAuth;
import com.ohgiraffers.middleTest.login.dto.MemberDTO;

public class MemberService {
    private SnsAuth snsAuth;

    public MemberService(SnsAuth snsAuth) {
        this.snsAuth = snsAuth;
    }

    public String findMember(MemberDTO memberDTO){
        boolean result = snsAuth.findMember(memberDTO);
        String type = String.valueOf(snsAuth.getClass()).split("impl.")[1];

        return type + "으로 로그인 " + result;
    }
}
