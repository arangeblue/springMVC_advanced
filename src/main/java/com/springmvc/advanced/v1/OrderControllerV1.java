package com.springmvc.advanced.v1;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.hellotrace.HelloTraceV0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



/**
 *@title : OrderControllerV1
 *@author : wikyubok 
 *@date : "2021-10-27 15:40:21"
 *@description : 
*/

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
    
    private final OrderServiceV1 orderServiceV1;
    private final HelloTraceV0 trace;

    @GetMapping("/v1/request")
    public String request(String itemId) {

        TraceStatus status = null;
        
        try{
            status = trace.begin("OrderControllerV1.request()");
            orderServiceV1.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {

            trace.exception(status, e);
            throw e; // 예외를 반드시 던져야 한다.
        
        }
       
    }
}
