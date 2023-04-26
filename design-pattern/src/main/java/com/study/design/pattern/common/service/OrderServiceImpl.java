package com.study.design.pattern.common.service;

import com.study.design.pattern.common.domain.Order;
import com.study.design.pattern.common.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }
}
