package com.xpd.spring.config;

import com.xpd.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

/**
 * 等同于配置文件
 */
@Configuration
@ComponentScan(value = "com.xpd.spring.ioc",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = {Service.class})
        }
)
public class MainConfig {

    @Bean("person")
    public Person person1() {
        return new Person("xpd1", 4);
    }

}
