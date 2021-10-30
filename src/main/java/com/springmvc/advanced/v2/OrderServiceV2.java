package com.springmvc.advanced.v2;

import com.springmvc.advanced.trace.TraceId;
import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.hellotrace.HelloTraceV1;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


/**
 *@title : OrderServiceV2
 *@author : wikyubok 
 *@date : "2021-10-27 15:40:14"
 *@description : 
*/

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    
    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV1 trace;

    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId ,"OrderServiceV2.orderItem()");
            orderRepositoryV2.save(status.getTraceId(), itemId);
            trace.end(status);
            
        } catch (Exception e) {

            trace.exception(status, e);
            throw e; // 예외를 반드시 던져야 한다.

        }
        
    }
}
