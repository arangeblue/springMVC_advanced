package com.springmvc.advanced.trace.logtrace;
import com.springmvc.advanced.trace.TraceStatus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
    

/**
 * @title : ThreadLocalLogTraceTest
 * @author : wikyubok
 * @date : "2021-10-28 15:03:45"
 * @description : ThreadLocalLogTrace에 대한 테스트
 */

public class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    @DisplayName("level2 ThreadLocalLogTrace에 대한 테스트 ")
    public void begin_end_level2() {

        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");

        trace.end(status2);
        trace.end(status1);

    }
    
    @Test
    @DisplayName("level2 ThreadLocalLogTrace Exception 상황에 대한 테스트")
    public void begin_exception_level2() {
        
    
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");

        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status1, new IllegalArgumentException());

    }
    
}
    