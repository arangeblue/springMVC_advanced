package com.springmvc.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;


/**
 *@title : ContextV2
 *@author : wikyubok 
 *@date : "2021-10-31 15:33:05"
 *@description : 전략패턴에서 실행 시점에서 Strategy를 파라미터로 바로 넘기는 방식
*/


@Slf4j
public class ContextV2 {
    
    

    public void execute(Strategy strategy) {

        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        strategy.call(); // 위임 - 상속과 다름
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long spentTime = endTime - startTime;
        log.info("spentTime : {}", spentTime);

    }

}
