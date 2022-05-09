package com.xpd.spring.ext;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ExtConfig.class);

        applicationContext.publishEvent(new MyApplicationEvent(new String("my event")) {
        });
    }
}
