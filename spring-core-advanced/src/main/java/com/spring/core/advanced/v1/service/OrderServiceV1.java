package com.spring.core.advanced.v1.service;

import com.spring.core.advanced.v1.Repository.OrderRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
