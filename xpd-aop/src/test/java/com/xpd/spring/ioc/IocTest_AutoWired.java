package com.xpd.spring.ioc;

import com.xpd.spring.bean.Person;
import com.xpd.spring.config.MainConfigOfAutowired;
import com.xpd.spring.config.MainConfigOfPropertyValue;
import com.xpd.spring.ioc.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IocTest_AutoWired {
    AnnotationConfigApplicationContext apc = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void test01() {
        printBeans(apc);

        BookService bean = apc.getBean(BookService.class);
        System.out.println(bean.toString());
    }

    private void printBeans(AnnotationConfigApplicationContext apc){
        String[] beanDefinitionNames = apc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
