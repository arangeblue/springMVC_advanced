package com.springmvc.advanced.v0;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


/**
 *@title : OrderServiceV0
 *@author : wikyubok 
 *@date : "2021-10-27 15:40:14"
 *@description : 
*/

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {
    
    private final OrderRepositoryV0 orderRepositoryV0;

    public void orderItem(String itemId) {
        orderRepositoryV0.save(itemId);
    }
}
