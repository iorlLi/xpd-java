package com.xpd.spring.ioc;

import com.xpd.spring.bean.Person;
import com.xpd.spring.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

public class IocTest_PropertyValue {
    AnnotationConfigApplicationContext apc = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);

    @Test
    public void test01() {
        printBeans(apc);

        Person person = (Person) apc.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = apc.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
    }

    private void printBeans(AnnotationConfigApplicationContext apc){
        String[] beanDefinitionNames = apc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
