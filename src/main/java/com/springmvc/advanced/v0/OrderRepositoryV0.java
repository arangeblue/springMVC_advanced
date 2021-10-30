package com.springmvc.advanced.v0;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;


/**
 *@title : OrderRepositoryV0
 *@author : wikyubok 
 *@date : "2021-10-27 15:39:16"
 *@description : 간단한 order repository
*/

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {
    
    public void save(String itemId) {
        
        if (itemId.equals("ex")) {
            throw new IllegalArgumentException("예외 발생");
        }
        sleep(1000);  // 1초
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
