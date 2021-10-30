package com.springmvc.advanced;

import com.springmvc.advanced.trace.logtrace.LogTrace;
import com.springmvc.advanced.trace.logtrace.ThreadLocalLogTrace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
