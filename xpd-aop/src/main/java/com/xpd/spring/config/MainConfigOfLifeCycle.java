package com.xpd.spring.config;

import com.xpd.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * bean的生命周期:
 * 创建  -- 初始化 -- 销毁
 * IOC容器管理bean的生命周期
 * 自定义初始化、销毁方法，容器在进行到当前对应阶段调用对应方法
 *
 * 单例：容器创建的时候，执行构造器和init方法， 容器关闭时销毁。
 * 多实例：每次获取时创建，容器不会调用销毁方法
 *
 * 1. 指定创建和销毁方法
 *      @Bean注解中指定  initMethod、destroyMethod
 * 2. 通过让bean实现 InitializingBean 和 DisposableBean
 *      重写afterPropertiesSet方法，在属性赋值之后执行
 * 3. JSR250的注解，从方法名可知，是在构造器之后执行，
 *          @PostConstruct 和 @PreDestroy
 */
@Configuration
@ComponentScan("com.xpd.spring")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Lazy
    public Car car() {
        return new Car();
    }


}
