package com.study.core.beanfind;

import com.study.core.config.AppConfig;
import com.study.core.member.MemberService;
import com.study.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Bean 이름 및 타입으로 조회")
    void findBeanByName() {
        MemberService memberService = annotationConfigApplicationContext.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("Bean 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = annotationConfigApplicationContext.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("Bean 구체 타입으로만 조회")
    void findBeanByTypeImpl() {
        MemberService memberService = annotationConfigApplicationContext.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("Bean 이름으로 조회 X")
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> annotationConfigApplicationContext.getBean("xx", MemberService.class));
    }
}
