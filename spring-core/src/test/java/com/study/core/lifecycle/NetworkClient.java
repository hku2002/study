package com.study.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 called, url : " + url);
        connect();
        call("call method call | 초기화 연결 메세지(생성자)");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 연결시 호출
    public void connect() {
        System.out.println("connect method called | url : " + url);
    }

    public void call(String message) {
        System.out.println("call method called | url : " + url + " | message : " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("disconnect method called | url : " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method called");
        connect();
        call("초기화 연결 메세지(afterPropertiesSet)");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy method called");
        disconnect();
    }
}
