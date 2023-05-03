package com.spring.core.advanced.v5.controller;

import com.spring.core.advanced.trace.callback.TraceCallback;
import com.spring.core.advanced.trace.callback.TraceTemplate;
import com.spring.core.advanced.trace.logtrace.LogTrace;
import com.spring.core.advanced.trace.template.AbstractTemplate;
import com.spring.core.advanced.v5.service.OrderServiceV5;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate traceTemplate;
    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.traceTemplate = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return traceTemplate.execute("OrderController.request()", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }
}
