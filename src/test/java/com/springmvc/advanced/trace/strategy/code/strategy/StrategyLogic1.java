package com.springmvc.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;


/**
 *@title : StrategyLogic1
 *@author : wikyubok 
 *@date : "2021-10-31 15:31:48"
 *@description : 전략 패턴에 따른 하위 클래스 logic1
*/


@Slf4j
public class StrategyLogic1 implements Strategy {

    @Override
    public void call() {
        log.info("비즈니스 로직 1 실행");
        log.info("비즈니스 로직 1 종료");
        
        
    }
    
}
