package com.study.core.web;

import com.study.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    public String logDemo(HttpServletRequest request) {
        myLogger.setRequestURL(String.valueOf(request.getRequestURI()));
        myLogger.log("== controller test ==");
        logDemoService.logic("testId");
        return "OK";
    }
}
