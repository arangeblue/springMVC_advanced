package com.springmvc.advanced.v3;

import com.springmvc.advanced.trace.TraceId;
import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.hellotrace.HelloTraceV1;
import com.springmvc.advanced.trace.logtrace.LogTrace;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


/**
 * @title : OrderServiceV3
 * @author : wikyubok
 * @date : "2021-10-27 15:40:14"
 * @description : helloTrace에서 LogTrace 변경
 */

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    
    private final OrderRepositoryV3 orderRepositoryV3;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        TraceStatus status = null;

        try {
            status = trace.begin("OrderServiceV3.orderItem()");
            orderRepositoryV3.save(itemId);
            trace.end(status);
            
        } catch (Exception e) {

            trace.exception(status, e);
            throw e; // 예외를 반드시 던져야 한다.

        }
        
    }
}
