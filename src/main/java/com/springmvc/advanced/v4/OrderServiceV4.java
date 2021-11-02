package com.springmvc.advanced.v4;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.logtrace.LogTrace;
import com.springmvc.advanced.trace.template.AbstractTemplate;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


/**
 * @title : OrderServiceV4
 * @author : wikyubok
 * @date : "2021-10-27 15:40:14"
 * @description : 템플릿 메서드 패턴으로 변경
 */

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    
    private final OrderRepositoryV4 orderRepositoryV4;
    private final LogTrace trace;

    public void orderItem(String itemId) {


        TraceStatus status = null;
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {

            @Override
            protected Void call() {
                orderRepositoryV4.save(itemId);
                return null;
            }

        };

        template.execute("OrderServiceV4.orderItem()");

    }
}
