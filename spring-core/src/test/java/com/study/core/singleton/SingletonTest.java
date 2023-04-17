package com.study.core.singleton;

import com.study.core.config.AppConfig;
import com.study.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너 사용시 다른 인스턴스가 된다.")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberServiceFirst = appConfig.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberServiceSecond = appConfig.memberService();

        assertThat(memberServiceFirst).isNotSameAs(memberServiceSecond);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용시 같은 인스턴스가 된다.")
    void singletonServiceTest() {

        // 1. 조회: 호출할 때 같은 인스턴스 조회
        SingletonService singletonServiceFirst = SingletonService.getInstance();

        // 2. 조회: 호출할 때 같은 인스턴스 조회
        SingletonService singletonServiceSecond = SingletonService.getInstance();

        assertThat(singletonServiceFirst).isSameAs(singletonServiceSecond);
    }

    @Test
    @DisplayName("스프링 컨테이너 사용시 같은 인스턴스가 된다.")
    void springContainer() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberServiceFirst = annotationConfigApplicationContext.getBean("memberService", MemberService.class);

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberServiceSecond = annotationConfigApplicationContext.getBean("memberService", MemberService.class);

        assertThat(memberServiceFirst).isSameAs(memberServiceSecond);
    }
}
