package com.xpd.spring.aop;

import com.xpd.spring.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext apc = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

        Calc bean = apc.getBean(Calc.class);
        int div = bean.div(2, 1);
        bean.sum(555, 6000);

        String[] beanDefinitionNames = apc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
