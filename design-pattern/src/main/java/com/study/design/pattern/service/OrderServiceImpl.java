package com.study.design.pattern.service;

import com.study.design.pattern.domain.Order;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrder() {
        return null;
    }
}
