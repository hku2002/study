package com.study.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean singletonBeanFirst = applicationContext.getBean(SingletonBean.class);
        SingletonBean singletonBeanSecond = applicationContext.getBean(SingletonBean.class);
        System.out.println("singletonBeanFirst : " + singletonBeanFirst);
        System.out.println("singletonBeanSecond : " + singletonBeanSecond);

        assertThat(singletonBeanFirst).isSameAs(singletonBeanSecond);
        applicationContext.close();
    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
