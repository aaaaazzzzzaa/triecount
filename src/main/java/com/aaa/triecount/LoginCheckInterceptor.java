package com.aaa.triecount;

import com.aaa.triecount.service.MemberService;
import com.aaa.triecount.util.TriecountApiConst;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Cookie[] cookies = request.getCookies();

        // 쿠키 사용자 정보 X -> return false
        if (!this.containsUserCookie(cookies)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }

        // 쿠키 사용자 정보 O -> 값을 세팅해줌
        for (Cookie cookie : cookies) {
            if (TriecountApiConst.LOGIN_MEMBER_COOKIE.equals(cookie.getName())) {
                try {
                    // cookie에서 id(member entity의 pk) 를 꺼내고, DB에서 이 아이디에 해당하는 member 조회
                    M
                }
            }
        }
    }

    private boolean containsUserCookie(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (TriecountApiConst.LOGIN_MEMBER_COOKIE.equals(cookie.getName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
