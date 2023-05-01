package com.study.design.pattern.proxy.service;

import com.study.design.pattern.common.domain.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class RealOrderService implements OrderService {
    @Override
    public Optional<Order> getOrder(Long id) {
        log.info("real getOrder 호출");
        return Optional.empty();
    }

    @Override
    public void completeOrder(Long id) {
        log.info("real completeOrder 호출");
    }
}
