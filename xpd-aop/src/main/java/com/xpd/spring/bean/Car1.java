package com.xpd.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Car1 implements InitializingBean, DisposableBean {

    public Car1(){
        System.out.println("Car1...constructor...");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("Car1...destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car1...afterPropertiesSet...");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Car1...postConstruct...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Car1...preDestroy...");
    }
}
