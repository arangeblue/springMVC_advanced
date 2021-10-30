package com.springmvc.advanced.trace.hellotrace;
import com.springmvc.advanced.trace.TraceStatus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
    

@DisplayName("HelloTraceV1에 대한 log 테스트, 파라미터를 sync해주었기 때문에 id와 level이 잘 표현되어야 함.")
public class HelloTraceV1Test {

    @Test
    @DisplayName("HelloTraceV1에 대한 log 테스트, 파라미터를 sync해주었기 때문에 id와 level이 정상작동 해야함")
    public void begin_end() {
        // given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus beginStatus = trace.begin("hello");
        TraceStatus statusNext = trace.beginSync(beginStatus.getTraceId(), beginStatus.getMessage());
        trace.end(statusNext);
        trace.end(beginStatus);
    }

    @Test
    @DisplayName("HelloTraceV1에 대한 log exception 테스트")
    public void begin_exception(){
        // given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus beginStatus = trace.begin("안녕");
        TraceStatus nextStatus = trace.beginSync(beginStatus.getTraceId(), beginStatus.getMessage());
        trace.exception(nextStatus, new IllegalArgumentException());
        trace.exception(beginStatus, new IllegalArgumentException());

    }
    

}
    