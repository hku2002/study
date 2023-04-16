package com.study.core.config;

import com.study.core.discount.DiscountPolicy;
import com.study.core.discount.FixDiscountPolicy;
import com.study.core.member.MemberService;
import com.study.core.member.MemberServiceImpl;
import com.study.core.member.MemoryMemberRepository;
import com.study.core.order.OrderService;
import com.study.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy getDiscountPolicy() {
        return new FixDiscountPolicy();
    }
}
