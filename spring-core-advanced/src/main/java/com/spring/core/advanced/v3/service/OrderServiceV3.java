package com.spring.core.advanced.v3.service;

import com.spring.core.advanced.trace.TraceId;
import com.spring.core.advanced.trace.TraceStatus;
import com.spring.core.advanced.trace.hellotrace.HelloTraceV2;
import com.spring.core.advanced.trace.logtrace.LogTrace;
import com.spring.core.advanced.v3.Repository.OrderRepositoryV3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
