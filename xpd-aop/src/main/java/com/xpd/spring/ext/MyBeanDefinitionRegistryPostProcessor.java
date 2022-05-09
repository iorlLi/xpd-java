package com.xpd.spring.ext;

import com.xpd.spring.bean.Green;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        int beanDefinitionCount = registry.getBeanDefinitionCount();
        System.out.println("postProcessBeanDefinitionRegistry..beanDefinitionCount :" + beanDefinitionCount);
        // RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Green.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Green.class).getBeanDefinition();
        registry.registerBeanDefinition("green1", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        System.out.println("postProcessBeanFactory..beanDefinitionCount :" + beanDefinitionCount);
    }
}
