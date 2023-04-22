package com.study.design.pattern.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "ORDERS")
@NoArgsConstructor(access = PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long userId;
    private String orderName;
    private int totalPrice;

    @Builder
    public Order(Long id, Long userId, String orderName, int totalPrice) {
        this.id = id;
        this.userId = userId;
        this.orderName = orderName;
        this.totalPrice = totalPrice;
    }

}
