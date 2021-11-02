package com.springmvc.advanced.v4;

import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.logtrace.LogTrace;
import com.springmvc.advanced.trace.template.AbstractTemplate;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;


/**
 * @title : OrderRepositoryV4
 * @author : wikyubok
 * @date : "2021-10-27 15:39:16"
 * @description : 템플릿 메서드 패턴으로 변경
 */

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {
    
    private final LogTrace trace;

    public void save(String itemId) {

        TraceStatus status = null;
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {

            @Override
            protected Void call() {

                if (itemId.equals("ex")) {
                    throw new IllegalArgumentException("예외 발생");
                }
                sleep(1000); // 1초

                return null;
            }
        };

        template.execute("OrderRepositoryV4.save()");
    }


        private void sleep(int i) {
            try {
                Thread.sleep(i);

            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
}
