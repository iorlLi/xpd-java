package com.xpd.spring.ioc;

import com.xpd.spring.bean.Person;
import com.xpd.spring.config.MainConfig;
import com.xpd.spring.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class IocTest {
    AnnotationConfigApplicationContext apc
            = new AnnotationConfigApplicationContext(MainConfig.class);

    AnnotationConfigApplicationContext apc2
            = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void  testImport(){
        printBeans(apc2);

        Object colorFactoryBean = apc2.getBean("colorFactoryBean");
        Object factoryBean = apc2.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
        System.out.println(factoryBean.getClass());
    }

    @Test
    public void test01() {
        printBeans(apc);

        System.out.println("IOC 容器初始化完成......");
        Object person = apc.getBean("person");
        Object person2 = apc.getBean("person");

        System.out.println(person == person2);

        Map<String, Person> beansOfType = apc.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    void printBeans(AnnotationConfigApplicationContext apc){
        String[] beanDefinitionNames = apc.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
