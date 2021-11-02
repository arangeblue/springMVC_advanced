package com.springmvc.advanced.trace.template;

import com.springmvc.advanced.trace.template.code.AbstractTemplate;
import com.springmvc.advanced.trace.template.code.SubClassLogic1;
import com.springmvc.advanced.trace.template.code.SubClassLogic2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodTest {
    

    @Test
    @DisplayName("템플릿 메소드 패턴 테스트")
    public void templateMethodV0() {
        
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
    @DisplayName("템플릿 메서드 패턴에 대한 테스트")
    public void templateMethodPatternV1() {
        
        SubClassLogic1 template1 = new SubClassLogic1();
        template1.execute();

        SubClassLogic2 template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    @DisplayName("템플릿 메서드 패턴에서 익명 내부 클래스로 v1의 문제 해결")
    public void templateMethodPatternV2() {
        
    
        AbstractTemplate template1 = new AbstractTemplate() {

            @Override
            protected void call() {
                log.info("비즈니스 로직 1 실행");
                log.info("비즈니스 로직 1 종료");
                
            }
            
        };
        
        log.info("클래스 이름1 = {}", template1.getClass());
        template1.execute();


        AbstractTemplate template2 = new AbstractTemplate() {

            @Override
            protected void call() {
                log.info("비즈니스 로직 2 실행");
                log.info("비즈니스 로직 2 종료");

            }

        };


        log.info("클래스 이름2 = {}", template2.getClass());
        template2.execute();
    
    }


}
