package com.xpd.spring.config;

import com.xpd.spring.bean.Color;
import com.xpd.spring.bean.ColorFactoryBean;
import com.xpd.spring.bean.Person;
import com.xpd.spring.condition.MyBeanDefinitionRegistrar;
import com.xpd.spring.condition.MyCondition;
import com.xpd.spring.condition.MyImportSelector;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 等同于配置文件
 */
//@Configuration
@ComponentScans(value = {
        @ComponentScan(value = "com.xpd.spring.ioc")
})
@Import({MyImportSelector.class, Color.class, MyBeanDefinitionRegistrar.class})
public class MainConfig2 {

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
     * 3. @Import   直接指定某个类，
     *              selector选择批量导入，导入的类的id是全限名
     *              ImportBeanDefinitionRegistrar :手工导入类， 导入类的id自己指定
     * 4. FactoryBean：默认获取的是工厂类调用getObject创建的对象
     *                      如果需要获取工厂bean本身，使用前缀:  &colorFactoryBean
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
        return new Person("windows", 66, "gac");
    }

    /*
        class com.xpd.spring.bean.Color
        注册的是factoryBean，实际注入的是getObject()返回的对象。
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
