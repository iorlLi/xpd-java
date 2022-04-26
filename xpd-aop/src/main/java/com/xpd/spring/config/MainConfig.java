package com.xpd.spring.config;

import com.xpd.spring.bean.Person;
import com.xpd.spring.condition.MyCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 等同于配置文件
 */
@Configuration
//@ComponentScan(value = "com.xpd.spring.ioc")
/*

        ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = {Service.class})
        }
 */
// 使用include过滤时， 需要指定默认规则为false：useDefaultFilters = false
// excludeFilters 根据type排除相关类扫描，useDefaultFilters 默认为true
@ComponentScans(value = {
        @ComponentScan(value = "com.xpd.spring.ioc", includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
})

public class MainConfig {

    /**
     * singleton: IOC容器初始化时候加载bean，
     * prototype: 每次getBean时候再加载
     * 针对单例bean：
     *
     * @Lazy: IOC初始化时不再创建，第一次获取时候再加载
     * <p>
     * <p>
     * 给容器中注册组件：
     * 1. 包扫描 + 注解， 如@service, @controller   本项目中的类
     * 2. @bean注解， 导入第三方包中的类
     * 3. @Import
     */
    @Bean("person")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public Person person1() {
        System.out.println("IOC 加载bean..");
        return new Person("xpd1", 4, "xpdd");
    }

    @Bean
    @Conditional(value = {MyCondition.class})
    public Person person01() {
        return new Person("windows", 66, "gas");
    }
}
