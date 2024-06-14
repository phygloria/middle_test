package com.ohgiraffers.middleTest.login;

import com.ohgiraffers.middleTest.login.auth.impl.GoogleAuth;
import com.ohgiraffers.middleTest.login.auth.impl.KakaoAuth;
import com.ohgiraffers.middleTest.login.auth.impl.NaverAuth;
import com.ohgiraffers.middleTest.login.dto.MemberDTO;
import com.ohgiraffers.middleTest.login.service.MemberService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello world!");

        String id = "";
        String pwd = "";
        boolean result;

        do {
            System.out.println("----- 로그인 프로그램 시작 -----");
            System.out.println("1. google 로그인");
            System.out.println("2. naver 로그인");
            System.out.println("3. kakao 로그인");
            System.out.println("9. 프로그램 종료");
            System.out.println("로그인 한 인증 수단을 선택해주세요:");
            int choice = scanner.nextInt();

            scanner.nextLine();  // 개행 문자를 소비합니다.
            System.out.print("아이디를 입력해주세요: ");
            id = scanner.nextLine();
            System.out.print("비밀번호를 입력해주세요: ");
            pwd = scanner.nextLine();

            MemberDTO memberDTO = new MemberDTO(id, pwd);
            MemberService memberService = null;

            switch (choice) {
                case 1:
                    memberService = new MemberService(new GoogleAuth());
                    break;
                case 2:
                    memberService = new MemberService(new NaverAuth());
                    break;
                case 3:
                    memberService = new MemberService(new KakaoAuth());
                    break;
                case 9:
                    System.out.println("로그인을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
                    continue;
            }

            result = Boolean.parseBoolean(memberService.findMember(memberDTO));
            if (result) {
                System.out.println("로그인에 성공하였습니다: " + memberDTO.getId());
            } else {
                System.out.println("로그인에 실패하였습니다.");
            }

        } while (true);
    }
}