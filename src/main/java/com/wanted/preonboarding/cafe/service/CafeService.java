package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.CafeRequest;
import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(Map<Menu, Integer> request){
        // 들어온 주문에 따라 적절한 Beverage 객체를 상속받은 객체를 생성
        // Cashier 생성자 파라미터에 Barista 추가 필요
        Cashier cashier = new Cashier(wantedCafe);
        Customer c1 = new Customer("Card", request);
        return c1.buyCoffee(cashier);
    }
}
