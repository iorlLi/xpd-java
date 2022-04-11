package com.xpd.spring.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();

        // 判断容器中bean的注册情况， 也可以使用registry注册新的bean到容器中
        BeanDefinitionRegistry registry = context.getRegistry();
        boolean containsBeanDefinition = registry.containsBeanDefinition("person");
        if(containsBeanDefinition){

        }


        String property = environment.getProperty("os.name");
        if(property.contains("Windows")){
            return true;
        }
        return false;
    }
}
