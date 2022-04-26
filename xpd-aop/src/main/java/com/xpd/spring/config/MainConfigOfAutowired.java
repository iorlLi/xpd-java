package com.xpd.spring.config;

import com.xpd.spring.bean.Person;
import com.xpd.spring.ioc.dao.BookDao;
import org.springframework.context.annotation.*;

/**
 * PropertySource：将配置的属性，k/v加载到运行时环境中
 */
@Configuration
@ComponentScan(value = {"com.xpd.spring.ioc.controller","com.xpd.spring.ioc.service","com.xpd.spring.ioc.dao"})
public class MainConfigOfAutowired {

    @Bean
    @Primary
    public BookDao bookDao2() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("bean 2");
        return bookDao;
    }

}
