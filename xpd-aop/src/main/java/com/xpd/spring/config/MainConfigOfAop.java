package com.xpd.spring.config;

import com.xpd.spring.aop.Calc;
import com.xpd.spring.aop.aspect.CalcLogAspect;
import com.xpd.spring.bean.Person;
import com.xpd.spring.condition.MyCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 等同于配置文件
 */
@Configuration
@EnableAspectJAutoProxy
@Import(Calc.class)
public class MainConfigOfAop {

    //@Bean
    public Calc calc() {
        return new Calc();
    }

    @Bean
    public CalcLogAspect calcLogAspect(){
        return new CalcLogAspect();
    }
}
