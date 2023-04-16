package com.study.core.order;

import com.study.core.member.Grade;
import com.study.core.member.Member;
import com.study.core.member.MemberService;
import com.study.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void order() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "홍길동", Grade.VIP);

        // when
        memberService.join(member);
        Order order = orderService.createOrder(1L, "주문 테스트 item", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
