package com.xpd.spring.ext;

import com.xpd.spring.bean.RainBow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.xpd.spring.ext")
public class ExtConfig {
    /**
     * 1). BeanFactoryPostProcessor : beanFactory的后置处理器
     *  在beanFactory标准初始化之后调用，来定制和修改BeanFactory的内容
     *  所有的bean定义已经加载到beanFactory，但是bean的实例还没创建
     *
     *  BeanFactoryPostProcessor原理：断点打在重写方法上，看调用栈信息
     *      1. IOC容器启动时
     *      2. invokeBeanFactoryPostProcessors
     *             方法invokeBeanFactoryPostProcessors，按照类型找到所有的
     *              beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, ....);
     *              按照实现 PriorityOrdered,Ordered和普通的后置处理器顺序执行。
     *
     * 2) BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
     *  为BeanFactoryPostProcessor实现类，优先执行，都在方法invokeBeanFactoryPostProcessors里面
     *  可以给容器再注册新的bean。
     *
     *  3). ApplicationListener: 监听容器中发布的事件，监听ApplicationEvent及其子类
     *      步骤： 1. 写一个如 MyApplicationListener 监听某个事件
     *            2. 把监听器加入到容器
     *            3. 只要容器中有事件发生，就能监听到： onApplicationEvent
     *            4. 发布一个事件：
     *                    applicationContext.publishEvent(new MyApplicationEvent(new String("my event")) {
     *         });
     *
     *         或者在方法上使用@EventListener注解：
     *         @see ListenerService.listener
     *         原理：
     *         EventListenerMethodProcessor  打上断点，启动IOC
     *         SmartInitializingSingleton.afterSingletonsInstantiated,
     *         1. refresh()
     *         2. finishBeanFactoryInitialization(beanFactory)
     *         3. preInstantiateSingletons：
     *              先创建好所有单实例bean，
     *              获取上一步创建好的bean，判断 singletonInstance instanceof SmartInitializingSingleton
     *              如果是，调用 afterSingletonsInstantiated
     *
     *
     *  原理：
     *      ContextRefreshedEvent
     *      1. refresh()
     *      2. publishEvent(new ContextRefreshedEvent(this))
     *      3. 获取多播器，广播， 可以同步或者异步
     *          getApplicationEventMulticaster().multicastEvent(applicationEvent, eventType)
     *                  for (ApplicationListener<?> listener : getApplicationListeners(event, type))
     *
     *     事件多播器：
     *      1. refresh()
     *      2. initApplicationEventMulticaster();
     *          applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory)
     *
     *      容器有哪些监听器：
     *          1. refresh()
     *          2. registerListeners()
     *          3. String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false)
     *          4. 加入到多播器
     *              getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName)
     */
    @Bean
    public RainBow rainBow(){
        return new RainBow();
    }

}
