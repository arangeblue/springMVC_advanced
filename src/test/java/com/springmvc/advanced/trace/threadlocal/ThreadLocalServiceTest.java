package com.springmvc.advanced.trace.threadlocal;

import com.springmvc.advanced.trace.threadlocal.code.ThreadLocalService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    
    @Test
    @DisplayName("threadlocal을 가지고 동시성 문제 해결")
    public void thread_field() {
        
    
        log.info("main start");

        Runnable userA = ()->{
            service.logic("userA");
        };

        Runnable userB = ()->{
            service.logic("userB");
        };


        Thread threadA = new Thread(userA);
        threadA.setName("userA");

        Thread threadB = new Thread(userB);
        threadB.setName("userB");

        threadA.start();
        // sleep(2000); // a 작업이 완전히 끝나고 b 시작, 동시성 문제 발생 x로 예상 
        sleep(100); // a작업이 완전히 끝나지 않고 b 시작, 동시성 문제 발생 o로 예상

        threadB.start();
        sleep(3000);


        log.info("main exit");


        // 결과 
        // 17:05:13.355 [main] INFO com.springmvc.advanced.trace.threadlocal.ThreadLocalServiceTest - main start
        // 17:05:13.364 [userA] INFO com.springmvc.advanced.trace.threadlocal.code.ThreadLocalService - 저장 name=userA -> nameSpace=null
        // 17:05:14.385 [userA] INFO com.springmvc.advanced.trace.threadlocal.code.ThreadLocalService - 조회 nameSpace=userA
        // 17:05:15.368 [userB] INFO com.springmvc.advanced.trace.threadlocal.code.ThreadLocalService - 저장 name=userB -> nameSpace=null
        // 17:05:16.376 [userB] INFO com.springmvc.advanced.trace.threadlocal.code.ThreadLocalService - 조회 nameSpace=userB
        // 17:05:18.368 [main] INFO com.springmvc.advanced.trace.threadlocal.ThreadLocalServiceTest - main exit

    
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
    