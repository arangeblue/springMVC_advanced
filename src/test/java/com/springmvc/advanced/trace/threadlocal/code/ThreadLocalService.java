package com.springmvc.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {
    
    private ThreadLocal<String> nameSpace = new ThreadLocal<>();

    public String logic(String name) {
        log.info("저장 name={} -> nameSpace={}", name, nameSpace.get());
        nameSpace.set(name);
        sleep(1000);

        log.info("조회 nameSpace={}", nameSpace.get());

        return nameSpace.get();

        
    }

    private void sleep(int i) {
        
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        
    }
}
