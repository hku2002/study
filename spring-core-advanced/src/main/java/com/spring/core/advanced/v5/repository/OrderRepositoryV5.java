package com.spring.core.advanced.v5.repository;

import com.spring.core.advanced.trace.callback.TraceCallback;
import com.spring.core.advanced.trace.callback.TraceTemplate;
import com.spring.core.advanced.trace.logtrace.LogTrace;
import com.spring.core.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate traceTemplate;

    public OrderRepositoryV5(LogTrace logTrace) {
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    public void save(String itemId) {

        traceTemplate.execute("OrderRepository.save()", () -> {
            if ("ex".equals(itemId)) {
                throw new IllegalStateException("예외발생");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
