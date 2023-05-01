package com.study.design.pattern.proxy.service;

import com.study.design.pattern.common.domain.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class ProxyOrderService implements OrderService {
    public OrderService orderService;

    public ProxyOrderService(RealOrderService realOrderService) {
        this.orderService = realOrderService;
    }

    @Override
    public Optional<Order> getOrder(Long id) {
        log.info("proxy getOrder 호출");
        return Optional.empty();
    }

    @Override
    public void completeOrder(Long id) {
        this.orderService.completeOrder(id);
    }
}
