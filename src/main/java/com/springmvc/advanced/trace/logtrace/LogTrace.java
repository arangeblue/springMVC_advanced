package com.springmvc.advanced.trace.logtrace;

import com.springmvc.advanced.trace.TraceStatus;

public interface LogTrace {
    
    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
    }
