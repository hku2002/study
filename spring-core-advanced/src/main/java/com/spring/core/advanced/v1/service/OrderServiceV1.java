package com.spring.core.advanced.v1.service;

import com.spring.core.advanced.trace.TraceStatus;
import com.spring.core.advanced.trace.hellotrace.HelloTraceV1;
import com.spring.core.advanced.v1.repository.OrderRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId) {
        TraceStatus status = trace.begin("OrderService.request()");
        try {
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
