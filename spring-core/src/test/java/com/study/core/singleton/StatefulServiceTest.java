package com.study.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 사용시 메모리 공유 문제 확인")
    void statefulServiceSingleton() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SampleConfig.class);
        StatefulService statefulServiceFirst = applicationContext.getBean(StatefulService.class);
        StatefulService statefulServiceSecond = applicationContext.getBean(StatefulService.class);

        /* ThreadA: 사용자 A가 10,000원 주문 */
        statefulServiceFirst.order("userA", 10000);

        /* ThreadB: 사용자 A가 20,000원 주문 */
        statefulServiceSecond.order("userA", 20000);

        /* ThreadA: 사용자 A가 주문 금액 조회 */
        int price = statefulServiceFirst.getPrice();
        System.out.println("userA price : " + price);

        Assertions.assertThat(price).isNotEqualTo(10000);
    }

    static class SampleConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}