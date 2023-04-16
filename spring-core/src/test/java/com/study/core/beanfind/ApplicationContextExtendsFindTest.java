package com.study.core.beanfind;

import com.study.core.discount.DiscountPolicy;
import com.study.core.discount.FixDiscountPolicy;
import com.study.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SampleConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 2개 이상이면 중복 오류가 발생한다.")
    void findBeanByParentTypeDuplication() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> annotationConfigApplicationContext.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 2개 이상이면 Bean 이름을 지정하면 문제가 없다.")
    void findBeanByParentTypeBeanName() {
        DiscountPolicy discountPolicy = annotationConfigApplicationContext.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        RateDiscountPolicy rateDiscountPolicy = annotationConfigApplicationContext.getBean(RateDiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회")
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = annotationConfigApplicationContext.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType).hasSize(2);
    }

    @Configuration
    static class SampleConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
