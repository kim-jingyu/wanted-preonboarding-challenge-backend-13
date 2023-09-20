package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.CafeRequest;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("order")
    public String orderFromMenu() {
        Map<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.AMERICANO, 3);
        return cafeService.orderFrom(menu);
    }
}
