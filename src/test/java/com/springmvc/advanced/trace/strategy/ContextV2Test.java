package com.springmvc.advanced.trace.strategy;

import com.springmvc.advanced.trace.strategy.code.strategy.ContextV2;
import com.springmvc.advanced.trace.strategy.code.strategy.Strategy;
import com.springmvc.advanced.trace.strategy.code.strategy.StrategyLogic1;
import com.springmvc.advanced.trace.strategy.code.strategy.StrategyLogic2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 *@title : ContextV2Test
 *@author : wikyubok 
 *@date : "2021-10-31 16:19:38"
 *@description : 전략 패턴 v2에 대한 테스트, Context를 실행하는 시점에서 파라미터로 바로 넘기는 방식
*/


@Slf4j
public class ContextV2Test {
    

    @Test
    @DisplayName("전략패턴에서 Context를 실행하는 시점에서 파라미터로 바로바로 strategy를 넘기는 방법")
    public void strategyV1() {

        ContextV2 contextV2 = new ContextV2();

        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());

    }

    
    @Test
    @DisplayName("전략패턴에서 Context를 실행하는 시점에서 파라미터로 바로바로 strategy를 넘기는 방법 + 익명 내부 클래스")
    public void strategyV2() {

        ContextV2 contextV2 = new ContextV2();

        contextV2.execute(new Strategy() {

            @Override
            public void call() {

                log.info("비즈니스 로직 1 실행");
                log.info("비즈니스 로직 1 종료");

            }

        });

        contextV2.execute(new Strategy() {

            @Override
            public void call() {

                log.info("비즈니스 로직 2 실행");
                log.info("비즈니스 로직 2 종료");

            }

        });

    }
    

    @Test
    @DisplayName("전략패턴에서 Context를 실행하는 시점에서 파라미터로 바로바로 strategy를 넘기는 방법 + 익명 내부 클래스 + lambda")
    public void strategyV3() {

        ContextV2 contextV2 = new ContextV2();

        contextV2.execute(() -> {

            log.info("비즈니스 로직 1 실행");
            log.info("비즈니스 로직 1 종료");

        });

        contextV2.execute(() -> {

            log.info("비즈니스 로직 2 실행");
            log.info("비즈니스 로직 2 종료");

        });

    }


}
