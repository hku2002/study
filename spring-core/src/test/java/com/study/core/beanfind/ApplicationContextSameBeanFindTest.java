package com.study.core.beanfind;

import com.study.core.member.MemberRepository;
import com.study.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("Bean 을 타입으로 조회시 같은 타입이 두개 이상이면 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> annotationConfigApplicationContext.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("Bean 을 타입으로 조회시 같은 타입이 두개 이상이면 Bean 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberRepository memberRepository = annotationConfigApplicationContext.getBean("memberRepositoryFirst", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllByType() {
        Map<String, MemberRepository> beansOfType = annotationConfigApplicationContext.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key : " + key + " | value : " + beansOfType.get(key));
        }
        assertThat(beansOfType).hasSize(2);
    }

    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepositoryFirst() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepositorySecond() {
            return new MemoryMemberRepository();
        }
    }
}
