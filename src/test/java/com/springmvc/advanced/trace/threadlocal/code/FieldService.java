package com.springmvc.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {
    
    private String nameSpace;

    public String logic(String name) {
        log.info("저장 name={} -> nameSpace={}", name, nameSpace);
        nameSpace = name;
        sleep(1000);

        log.info("조회 nameSpace={}", nameSpace);

        return nameSpace;

        
    }

    private void sleep(int i) {
        
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        
    }
}
