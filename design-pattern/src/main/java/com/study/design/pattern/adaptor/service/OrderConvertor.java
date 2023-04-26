package com.study.design.pattern.adaptor.service;

import com.study.design.pattern.common.domain.Order;
import com.study.design.pattern.common.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderConvertor implements OrderAdaptor {

    private final OrderService orderService;

    @Override
    public Optional<Order> getOrder(int id) {
        return orderService.getOrder((long) id);
    }
}
