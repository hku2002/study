package com.study.design.pattern.proxy.service;

import com.study.design.pattern.common.domain.Order;

import java.util.Optional;

public interface OrderService {

    Optional<Order> getOrder(Long id);

    void completeOrder(Long id);
}
