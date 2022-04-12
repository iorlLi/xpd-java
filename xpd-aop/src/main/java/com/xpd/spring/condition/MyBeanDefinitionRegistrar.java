package com.xpd.spring.condition;

import com.xpd.spring.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 原来beanDefinition是这样初始化的: RootBeanDefinition
     * registry: 有IOC容器所有的beanDefinition信息
     * @param importingClassMetadata 当前类的注解信息
     * @param registry               BeanDefinition注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean beanDefinition = registry.containsBeanDefinition("com.xpd.spring.bean.Red");
        boolean beanDefinition2 = registry.containsBeanDefinition("com.xpd.spring.bean.Green");

        if (beanDefinition2 && beanDefinition) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
