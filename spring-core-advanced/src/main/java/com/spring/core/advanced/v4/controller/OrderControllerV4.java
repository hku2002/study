package com.spring.core.advanced.v4.controller;

import com.spring.core.advanced.trace.TraceStatus;
import com.spring.core.advanced.trace.logtrace.LogTrace;
import com.spring.core.advanced.trace.template.AbstractTemplate;
import com.spring.core.advanced.v4.service.OrderServiceV4;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) {

        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("OrderController.request()");
    }
}
