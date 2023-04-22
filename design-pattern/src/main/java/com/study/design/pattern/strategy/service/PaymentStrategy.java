package com.study.design.pattern.strategy.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentStrategy {

    private final PaymentService paymentService;

    public String paymentMoney(int price) {
        return paymentService.payment(price);
    }
}
