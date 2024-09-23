package com.aaa.triecount.service;

import com.aaa.triecount.model.Member;
import com.aaa.triecount.repository.MemberRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    public Member signup(Member member) {
        // 중복 회원 체크
        memberRepository.findByLoginId(member.getLoginId())
                        .ifPresent(member1 -> {
                            throw new RuntimeException("이미 존재하는 id 입니다.");
                        });

        return memberRepository.save(member);
    }

    // 로그인
    public ResponseEntity<Void> login(
            @Valid @RequestBody LoginRequest loginRequest,
            HttpServletResponse response
    ) {
        Cookie idCookie = new Cookie()
    }

    // 로그아웃
}
