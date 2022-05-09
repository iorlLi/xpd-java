package com.xpd.spring.ioc.service;

import com.xpd.spring.ioc.dao.BookDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
/**
 * Autowired:先按照类型装配，如果有多个则按照name
 *  可搭配Qualifier使用，指定beanName
 *
 * Resource: Jsr250，java规范，按照beanName装配，可显式指定name，或者变量名
 *
 * Inject： JSR330， java规范，也是按照beanName装配，也支持 @Primary，首选注入。
 *
 * 自动装配由 AutowiredAnnotationBeanPostProcessor 完成
 *
 * 如果需要使用spring的底层组件，实现其对应的 aware组件
 *
 */
@Service
public class BookService implements ApplicationContextAware {

    //@Qualifier("bookDao")
    //@Autowired
    //@Resource(name = "bookDao2")
    //@Resource
    @Inject
    private BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
