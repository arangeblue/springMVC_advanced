package com.springmvc.advanced.trace.strategy;

import com.springmvc.advanced.trace.strategy.code.strategy.ContextV1;
import com.springmvc.advanced.trace.strategy.code.strategy.Strategy;
import com.springmvc.advanced.trace.strategy.code.strategy.StrategyLogic1;
import com.springmvc.advanced.trace.strategy.code.strategy.StrategyLogic2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;


/**
 * @title : ContextV1Test
 * @author : wikyubok
 * @date : "2021-10-31 15:40:11"
 * @description : 전략 패턴 테스트, 의존관계 주입을 통해 원하는 전략과 변하지 않는 context의 조합으로 코드를 만들 수 있음
 */

@Slf4j
public class ContextV1Test {
    

    @Test
    @DisplayName("템플릿 메소드 패턴 테스트")
    public void strategyPattern() {
        
        logic2();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 시작");
        log.info("비즈니스 로직1 종료");
        // 비즈니스 로직 종료
        
        long endTime = System.currentTimeMillis();

        long spentTime = endTime - startTime;

        log.info("spentTime : {}", spentTime);

    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 시작");
        log.info("비즈니스 로직2 종료");
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();

        long spentTime = endTime - startTime;

        log.info("spentTime : {}", spentTime);

    }
    

    @Test
    @DisplayName("전략 패턴에 따른 테스트 v1")
    public void strategyV1() {
        // given
        StrategyLogic1 strategy1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategy1);

        StrategyLogic2 strategy2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategy2);

        // when
        contextV1.execute();
        contextV2.execute();

        // then
    }
    
    @Test
    @DisplayName("내부 익명 클래스v1로 전략패턴 테스트")
    public void strategyV2() {

        Strategy strategy1 = new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
                log.info("비즈니스 로직 1 종료");

            }

        };

        ContextV1 contextV1_logic1 = new ContextV1(strategy1);
        log.info("class name = {}", strategy1.getClass());
        contextV1_logic1.execute();

        Strategy strategy2 = new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
                log.info("비즈니스 로직 2 종료");

            }

        };

        ContextV1 contextV1_logic2 = new ContextV1(strategy2);
        log.info("class name = {}", strategy2.getClass());
        contextV1_logic2.execute();

    }

    
    @Test
    @DisplayName("내부 익명 클래스v2로 전략패턴 테스트, v2에서 인라인으로 변경")
    public void strategyV3() {

        ContextV1 contextV1_logic1 = new ContextV1(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
                log.info("비즈니스 로직 1 종료");

            }

        });

        contextV1_logic1.execute();

        ContextV1 contextV1_logic2 = new ContextV1(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
                log.info("비즈니스 로직 2 종료");

            }

        });

        contextV1_logic2.execute();

    }
    

    @Test
    @DisplayName("내부 익명 클래스로 전략패턴 테스트, lambda를 사용하여 변경")
    public void strategyV4() {
        

        ContextV1 contextV1_logic1 = new ContextV1(() -> {
            log.info("비즈니스 로직 1 실행");
            log.info("비즈니스 로직 1 종료");

        });

        contextV1_logic1.execute();

        ContextV1 contextV1_logic2 = new ContextV1(() -> {
            log.info("비즈니스 로직 2 실행");
            log.info("비즈니스 로직 2 종료");

        });

        contextV1_logic2.execute();

    }


}
