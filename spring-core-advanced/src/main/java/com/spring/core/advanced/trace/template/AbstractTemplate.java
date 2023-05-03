package com.spring.core.advanced.trace.template;

import com.spring.core.advanced.trace.TraceStatus;
import com.spring.core.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    protected abstract T call();
}
