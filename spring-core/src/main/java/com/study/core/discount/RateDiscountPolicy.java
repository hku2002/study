package com.study.core.discount;

import com.study.core.member.Grade;
import com.study.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountFixPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountFixPercent / 100;
        }
        return 0;
    }
}
