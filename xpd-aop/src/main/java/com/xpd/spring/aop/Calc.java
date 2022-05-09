package com.xpd.spring.aop;

import com.xpd.spring.aop.aspect.LogAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calc {
    public Integer div(int a, int b) {
        System.out.println(">>>>>>>> Calc...div...");
        return a / b;
    }
    @LogAnnotation
    @GetMapping("/test")
    public Integer sum(int a, int b) {
        System.out.println(">>>>>>>> Calc...sum...");
        return a + b;
    }
}
