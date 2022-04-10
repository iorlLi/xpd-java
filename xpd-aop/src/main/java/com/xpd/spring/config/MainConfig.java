package com.xpd.spring.config;

import com.xpd.spring.bean.Person;
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
@ComponentScans(value = {
        @ComponentScan(value = "com.xpd.spring.ioc", includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
})
public class MainConfig {

    @Bean("person")
    public Person person1() {
        return new Person("xpd1", 4);
    }

}
