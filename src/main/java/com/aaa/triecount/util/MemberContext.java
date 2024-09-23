package com.aaa.triecount.util;

import com.aaa.triecount.model.Member;

public class MemberContext {

    private static final ThreadLocal<Member> memberThreadLocal = new ThreadLocal<>();

}
