package com.spring.core.advanced.v2.controller;

import com.spring.core.advanced.trace.TraceStatus;
import com.spring.core.advanced.trace.hellotrace.HelloTraceV1;
import com.spring.core.advanced.trace.hellotrace.HelloTraceV2;
import com.spring.core.advanced.v2.service.OrderServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId) {

        TraceStatus status = trace.begin("OrderController.request()");
        try {
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
