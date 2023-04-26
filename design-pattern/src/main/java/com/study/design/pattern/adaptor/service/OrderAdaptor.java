package com.study.design.pattern.adaptor.service;

import com.study.design.pattern.common.domain.Order;

import java.util.Optional;

public interface OrderAdaptor {

    Optional<Order> getOrder(int id);
}
