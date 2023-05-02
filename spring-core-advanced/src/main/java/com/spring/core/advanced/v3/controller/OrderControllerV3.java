package com.spring.core.advanced.v3.controller;

import com.spring.core.advanced.trace.TraceStatus;
import com.spring.core.advanced.trace.hellotrace.HelloTraceV2;
import com.spring.core.advanced.trace.logtrace.LogTrace;
import com.spring.core.advanced.v3.service.OrderServiceV3;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = trace.begin("OrderController.request()");
        try {
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
