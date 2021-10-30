package com.springmvc.advanced.v2;

import com.springmvc.advanced.trace.TraceId;
import com.springmvc.advanced.trace.TraceStatus;
import com.springmvc.advanced.trace.hellotrace.HelloTraceV0;
import com.springmvc.advanced.trace.hellotrace.HelloTraceV1;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;


/**
 *@title : OrderRepositoryV2
 *@author : wikyubok 
 *@date : "2021-10-27 15:39:16"
 *@description : 간단한 order repository
*/

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
    
    private final HelloTraceV1 trace;

    public void save(TraceId traceId, String itemId) {
        

        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId ,"OrderRepositoryV2.save()");
            
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("예외 발생");
            }
            sleep(1000); // 1초


            trace.end(status);

        } catch (Exception e) {

            trace.exception(status, e);
            throw e; // 예외를 반드시 던져야 한다.

        }

        
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
