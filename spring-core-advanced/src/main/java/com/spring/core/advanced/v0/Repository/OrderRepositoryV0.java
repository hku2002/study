package com.spring.core.advanced.v0.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId) {
        if ("ex".equals(itemId)) {
            throw new IllegalStateException("예외발생");
        }

        sleep(1000);
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
