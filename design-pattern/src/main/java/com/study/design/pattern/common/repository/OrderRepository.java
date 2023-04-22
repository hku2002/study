package com.study.design.pattern.common.repository;

import com.study.design.pattern.common.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
