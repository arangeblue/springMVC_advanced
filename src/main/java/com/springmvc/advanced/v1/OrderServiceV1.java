package com.springmvc.advanced.v1;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.hellotrace.HelloTraceV0;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


/**
 *@title : OrderServiceV1
 *@author : wikyubok 
 *@date : "2021-10-27 15:40:14"
 *@description : 
*/

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    
    private final OrderRepositoryV1 orderRepositoryV1;
    private final HelloTraceV0 trace;

    public void orderItem(String itemId) {

        TraceStatus status = null;

        try {
            status = trace.begin("OrderServiceV1.orderItem()");
            orderRepositoryV1.save(itemId);
            trace.end(status);
            
        } catch (Exception e) {

            trace.exception(status, e);
            throw e; // 예외를 반드시 던져야 한다.

        }
        
    }
}
