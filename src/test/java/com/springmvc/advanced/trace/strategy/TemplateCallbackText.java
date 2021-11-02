package com.springmvc.advanced.trace.strategy;

import com.springmvc.advanced.trace.strategy.code.templateCallback.Callback;
import com.springmvc.advanced.trace.strategy.code.templateCallback.TimeLogTemplate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateCallbackText {
    

    @Test
    @DisplayName("템플릿 콜백 패턴에 대한 테스트, 바로 내부 익명 클래스")
    public void callbackV1() {

        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(new Callback() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
                log.info("비즈니스 로직 1 종료");

            }

        });

        template.execute(new Callback() {

            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
                log.info("비즈니스 로직 2 종료");

            }

        });

    }
    


    @Test
    @DisplayName("템플릿 콜백 패턴에 대한 테스트, 바로 내부 익명 클래스 + Lambda")
    public void callbackV2() {

        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(() -> {
            log.info("비즈니스 로직 1 실행");
            log.info("비즈니스 로직 1 종료");

        });

        template.execute(() -> {
            log.info("비즈니스 로직 2 실행");
            log.info("비즈니스 로직 2 종료");

        });

    }
}
