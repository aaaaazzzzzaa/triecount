package com.aaa.triecount.controller;

import com.aaa.triecount.dto.SignupRequest;
import com.aaa.triecount.model.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Member> signUp(@Valid @RequestBody SignupRequest request) {
        Member member = Member.builder()
                              .loginId(request.getLoginId())
                              .password(request.getPassword())
                              .name(request.getName())
                              .build();

        return new ResponseEntity<>(memberService.signup())
    }


    // 로그인

    // 로그아웃
}
