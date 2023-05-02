package com.spring.core.advanced.v1.controller;

import com.spring.core.advanced.v1.service.OrderServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;

    @GetMapping("/v1/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }
}
