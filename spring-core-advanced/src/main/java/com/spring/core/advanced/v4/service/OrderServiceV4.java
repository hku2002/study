package com.spring.core.advanced.v4.service;

import com.spring.core.advanced.trace.TraceStatus;
import com.spring.core.advanced.trace.logtrace.LogTrace;
import com.spring.core.advanced.trace.template.AbstractTemplate;
import com.spring.core.advanced.v4.repository.OrderRepositoryV4;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.orderItem()");
    }
}
