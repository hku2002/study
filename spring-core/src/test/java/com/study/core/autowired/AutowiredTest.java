package com.study.core.autowired;

import com.study.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

class AutowiredTest {

    @Test
    void autoWiredOption() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBeanFirst(Member noBeanFirst) {
            System.out.println("noBeanFirst : " + noBeanFirst);
        }

        @Autowired
        public void setNoBeanSecond(@Nullable Member noBeanSecond) {
            System.out.println("noBeanSecond : " + noBeanSecond);
        }

        @Autowired
        public void setNoBeanThird(Optional<Member> noBeanThird) {
            System.out.println("noBeanThird : " + noBeanThird);
        }
    }
}
