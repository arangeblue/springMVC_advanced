package com.springmvc.advanced.v5;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.callback.TraceTemplate;
import com.springmvc.advanced.trace.logtrace.LogTrace;
import com.springmvc.advanced.trace.template.AbstractTemplate;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;


/**
 * @title : OrderRepositoryV5
 * @author : wikyubok
 * @date : "2021-10-27 15:39:16"
 * @description : 템플릿 콜백 패턴으로 변경
 */

@Repository
public class OrderRepositoryV5 {
    
    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }


    public void save(String itemId) {

        template.execute("OrderRepositoryV5.save()", () -> {
            
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("예외 발생");
            }
            sleep(1000); // 1초

            return null;
        });
      
    }


        private void sleep(int i) {
            try {
                Thread.sleep(i);

            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
}
