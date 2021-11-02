package com.springmvc.advanced.trace.callback;

public interface TraceCallback<T> {
    
    T call();

}
