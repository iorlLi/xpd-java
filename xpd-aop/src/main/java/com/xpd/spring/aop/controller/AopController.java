package com.xpd.spring.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/aop")
@RestController
public class AopController {
    Logger logger = LoggerFactory.getLogger(AopController.class);

    @GetMapping("/test")
    public String test(String name) {
        logger.info("name: " + name);
        return "test";
    }
}
