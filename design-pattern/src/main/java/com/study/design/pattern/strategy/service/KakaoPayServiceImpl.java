package com.study.design.pattern.strategy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KakaoPayServiceImpl implements PaymentService {
    @Override
    public String payment(int price) {
        log.info("카카오 페이 결제 구현체");
        return "카카오 페이 결제 성공";
    }
}
