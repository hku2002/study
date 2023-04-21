package com.study.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        ProtoTypeBean singletonBeanFirst = applicationContext.getBean(ProtoTypeBean.class);
        ProtoTypeBean singletonBeanSecond = applicationContext.getBean(ProtoTypeBean.class);

        assertThat(singletonBeanFirst).isNotSameAs(singletonBeanSecond);
        applicationContext.close();
    }

    @Scope("prototype")
    static class ProtoTypeBean {
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
