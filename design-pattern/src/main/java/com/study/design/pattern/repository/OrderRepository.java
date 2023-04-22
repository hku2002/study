package com.study.design.pattern.repository;

import com.study.design.pattern.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
