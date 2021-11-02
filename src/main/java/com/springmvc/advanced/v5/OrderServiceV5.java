package com.springmvc.advanced.v5;

import javax.security.auth.callback.Callback;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.callback.TraceTemplate;
import com.springmvc.advanced.trace.logtrace.LogTrace;
import com.springmvc.advanced.trace.template.AbstractTemplate;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


/**
 * @title : OrderServiceV5
 * @author : wikyubok
 * @date : "2021-10-27 15:40:14"
 * @description : 템플릿 콜백 패턴으로 변경
 */

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5, LogTrace trace) {
        this.orderRepositoryV5 = orderRepositoryV5;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        template.execute("OrderServiceV5.orderItem()", () -> {
            orderRepositoryV5.save(itemId);
            return null;
        });

    }
}
