package com.study.core.singleton;

import com.study.core.config.AppConfig;
import com.study.core.member.MemberRepository;
import com.study.core.member.MemberServiceImpl;
import com.study.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = applicationContext.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = applicationContext.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = applicationContext.getBean("getMemberRepository", MemberRepository.class);

        MemberRepository memberRepositoryFirst = memberService.getMemberRepository();
        MemberRepository memberRepositorySecond = orderService.getMemberRepository();

        assertSoftly(softly  ->{
            softly.assertThat(memberRepositoryFirst).isSameAs(memberRepositorySecond);
            softly.assertThat(memberRepositoryFirst).isSameAs(memberRepository);
        });
    }
}
