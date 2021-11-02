package com.springmvc.advanced.v4;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.logtrace.LogTrace;
import com.springmvc.advanced.trace.template.AbstractTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



/**
 * @title : OrderControllerV4
 * @author : wikyubok
 * @date : "2021-10-27 15:40:21"
 * @description : 템플릿 메서드 패턴으로 변경
 */

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {
    
    private final OrderServiceV4 OrderServiceV4;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) {

        
        TraceStatus status = null;
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {

            @Override
            protected String call() {
                OrderServiceV4.orderItem(itemId);
                return "ok";
            }
            
        }; 

        return template.execute("OrderControllerV4.request()");
    }
}
