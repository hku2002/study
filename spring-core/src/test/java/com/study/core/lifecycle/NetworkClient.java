package com.study.core.lifecycle;

public class NetworkClient {

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

    public void init() throws Exception {
        System.out.println("init method called");
        connect();
        call("초기화 연결 메세지(init)");
    }

    public void close() throws Exception {
        System.out.println("close method called");
        disconnect();
    }
}
