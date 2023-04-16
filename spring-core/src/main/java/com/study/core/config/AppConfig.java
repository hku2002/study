package com.study.core.config;

import com.study.core.discount.DiscountPolicy;
import com.study.core.discount.FixDiscountPolicy;
import com.study.core.member.MemberService;
import com.study.core.member.MemberServiceImpl;
import com.study.core.member.MemoryMemberRepository;
import com.study.core.order.OrderService;
import com.study.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    @Bean
    public MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
        return new FixDiscountPolicy();
    }
}
