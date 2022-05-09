package com.xpd.spring.tx;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {
    AnnotationConfigApplicationContext apc = new AnnotationConfigApplicationContext(TxConfig.class);
    @Test
    public void test(){
        UserService userService = apc.getBean(UserService.class);
        userService.insert();

    }
}
