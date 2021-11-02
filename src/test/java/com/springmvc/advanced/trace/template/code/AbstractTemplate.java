package com.springmvc.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {
    
    public void execute() {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        call(); // 상속 받아서 사용
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();

        long spentTime = endTime - startTime;

        log.info("spentTime : {}", spentTime);
    }

    protected abstract void call(); 

}
