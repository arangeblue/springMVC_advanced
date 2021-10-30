package com.springmvc.advanced.v3;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.logtrace.LogTrace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



/**
 * @title : OrderControllerV3
 * @author : wikyubok
 * @date : "2021-10-27 15:40:21"
 * @description : helloTrace에서 LogTrace 변경
 */

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {
    
    private final OrderServiceV3 OrderServiceV3;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = null;
        
        try{
            status = trace.begin("OrderControllerV3.request()");
            OrderServiceV3.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {

            trace.exception(status, e);
            throw e; // 예외를 반드시 던져야 한다.
        
        }
       
    }
}
