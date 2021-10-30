package com.springmvc.advanced.v2;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.hellotrace.HelloTraceV1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



/**
 *@title : OrderControllerV2
 *@author : wikyubok 
 *@date : "2021-10-27 15:40:21"
 *@description : 
*/

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {
    
    private final OrderServiceV2 orderServiceV2;
    private final HelloTraceV1 trace;

    @GetMapping("/v2/request")
    public String request(String itemId) {

        TraceStatus status = null;
        
        try{
            status = trace.begin("OrderControllerV2.request()");
            orderServiceV2.orderItem(status.getTraceId(),itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {

            trace.exception(status, e);
            throw e; // 예외를 반드시 던져야 한다.
        
        }
       
    }
}
