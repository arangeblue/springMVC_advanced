package com.springmvc.advanced.trace.hellotrace;
import com.springmvc.advanced.trace.TraceStatus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;    
    
public class helloTraceV0Test {


    @Test
    @DisplayName("Trace log에 대한 테스트, 실행 및 종료까지")
    public void begin_end() {
        // given
        HelloTraceV0 trace = new HelloTraceV0();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }
    
    @Test
    @DisplayName("trace log exception에 대한 테스트, trace를 시작하고 exception이 발생하면 어떻게 표현되는지 확인")
    public void begin_ex(){
        // given
        HelloTraceV0 trace = new HelloTraceV0();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalArgumentException());
        // when
    
    
        // then
    }

}
    