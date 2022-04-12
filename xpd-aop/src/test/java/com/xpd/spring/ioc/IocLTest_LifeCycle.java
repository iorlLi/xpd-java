package com.xpd.spring.ioc;

import com.xpd.spring.bean.Car;
import com.xpd.spring.bean.Car1;
import com.xpd.spring.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocLTest_LifeCycle {
    AnnotationConfigApplicationContext apc =
            new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    public void test1() {
        AnnotationConfigApplicationContext apc =
                new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("IOC 初始化完成");


        Car bean = apc.getBean(Car.class);
        System.out.println(bean);
        apc.close();
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext apc =
                new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("IOC 初始化完成");


        Car1 bean = apc.getBean(Car1.class);
        System.out.println(bean);
        apc.close();
    }
}
