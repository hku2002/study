package com.study.design.pattern.strategy.controller;

import com.study.design.pattern.strategy.service.NaverPayServiceImpl;
import com.study.design.pattern.strategy.service.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentController {

    @RequestMapping("/payment")
    public String payment() {
        PaymentStrategy paymentStrategy = new PaymentStrategy(new NaverPayServiceImpl());
        return paymentStrategy.paymentMoney(10000);
    }
}
