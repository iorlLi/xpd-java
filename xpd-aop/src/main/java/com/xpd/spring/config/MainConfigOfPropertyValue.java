package com.xpd.spring.config;

import com.xpd.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * PropertySource：将配置的属性，k/v加载到运行时环境中
 */
@Configuration
@PropertySource(value = {"classpath:/config/person.properties"})
public class MainConfigOfPropertyValue {

    @Bean
    public Person person() {
        return new Person();
    }

}
