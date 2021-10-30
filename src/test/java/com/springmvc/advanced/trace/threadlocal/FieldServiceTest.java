package com.springmvc.advanced.trace.threadlocal;

import com.springmvc.advanced.trace.threadlocal.code.FieldService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    @DisplayName(" 동시성 문제 테스트")
    public void field(){
        // given
        log.info("main start");

        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        // sleep(2000); // a가 완전히 작업을 끝내고 b를 실행, 동시성 문제 발생 x
        sleep(100); // a 작업이 끝나기 전에 b가 시작함, 동시성 문제 발생 o 
        threadB.start();

        sleep(3000); // 메인 쓰레드 종료 대기
        log.info("main exit");

    }

    private void sleep(int i) {

        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
