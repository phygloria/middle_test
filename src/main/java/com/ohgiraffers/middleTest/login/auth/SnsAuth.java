package com.ohgiraffers.middleTest.login.auth;

import com.ohgiraffers.middleTest.login.dto.MemberDTO;

public interface SnsAuth {
    boolean findMember(MemberDTO member);
}
