package com.xpd.spring.bean;

import com.xpd.spring.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {
    @Test
    public void test1() {
        ApplicationContext apc = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person1 = (Person) apc.getBean("person");
        Person bean = apc.getBean(Person.class);

        System.out.println(person1);
        System.out.println(bean);
    }
}
