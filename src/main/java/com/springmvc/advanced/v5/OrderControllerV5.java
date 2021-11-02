package com.springmvc.advanced.v5;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.callback.TraceCallback;
import com.springmvc.advanced.trace.callback.TraceTemplate;
import com.springmvc.advanced.trace.logtrace.LogTrace;
import com.springmvc.advanced.trace.template.AbstractTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



/**
 * @title : OrderControllerV5
 * @author : wikyubok
 * @date : "2021-10-27 15:40:21"
 * @description : 템플릿 콜백 패턴으로 변경
 */

@RestController
public class OrderControllerV5 {
    
    private final OrderServiceV5 OrderServiceV5;
    private final TraceTemplate template;



    public OrderControllerV5(com.springmvc.advanced.v5.OrderServiceV5 orderServiceV5, LogTrace trace) {
        OrderServiceV5 = orderServiceV5;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {

        return template.execute("OrderControllerV5.request()", new TraceCallback<String>() {

            @Override
            public String call() {
                OrderServiceV5.orderItem(itemId);
                return "ok";
            }
            
        });
    }
}
