package com.xpd.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Car1 implements InitializingBean, DisposableBean, ApplicationContextAware{

    public Car1() {
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
    public void postConstruct() {
        System.out.println("Car1...postConstruct...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Car1...preDestroy...");
    }

    // 注入容器对象 BeanPostProcessor 在spring中的应用
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
