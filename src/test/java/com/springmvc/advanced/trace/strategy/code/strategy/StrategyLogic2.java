package com.springmvc.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 *@title : StrategyLogic2
 *@author : wikyubok 
 *@date : "2021-10-31 15:31:28"
 *@description : 전략 패턴에 따른 하위 클래스 logic2
*/

@Slf4j
public class StrategyLogic2 implements Strategy{

    @Override
    public void call() {
        log.info("비즈니스 로직 2 실행");
        log.info("비즈니스 로직 2 종료");
        
    }
    
}
