package com.study.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonWithPrototypeFirstTest {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBeanFirst = applicationContext.getBean(PrototypeBean.class);
        prototypeBeanFirst.addCount();
        assertThat(prototypeBeanFirst.getCount()).isEqualTo(1);

        PrototypeBean prototypeBeanSecond = applicationContext.getBean(PrototypeBean.class);
        prototypeBeanSecond.addCount();
        assertThat(prototypeBeanFirst.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean clientBeanFirst = applicationContext.getBean(ClientBean.class);
        assertThat(clientBeanFirst.logic()).isEqualTo(1);

        ClientBean clientBeanSecond = applicationContext.getBean(ClientBean.class);
        assertThat(clientBeanSecond.logic()).isEqualTo(2);
    }

    @Scope("singleton")
    static class ClientBean {

        private final PrototypeBean prototypeBean;

        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }

    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init : " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy : ");
        }
    }
}
