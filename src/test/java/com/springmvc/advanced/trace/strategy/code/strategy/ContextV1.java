package com.springmvc.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;


/**
 *@title : ContextV1
 *@author : wikyubok 
 *@date : "2021-10-31 15:33:05"
 *@description : 전략패턴에서 필드에 전략을 보관하는 용도
*/


@Slf4j
public class ContextV1 {
    
    private Strategy strategy; // 이건 인터페이스니 구현체만 교체하면 된다.

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {

        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        strategy.call(); // 위임 - 상속과 다름
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();

        long spentTime = endTime - startTime;

        log.info("spentTime : {}", spentTime);


    }


}
