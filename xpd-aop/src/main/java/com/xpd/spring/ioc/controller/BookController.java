package com.xpd.spring.ioc.controller;

import com.xpd.spring.ioc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    /*
        现根据type注入，如果有多个，会再根据name属性获取
     */
    @Autowired
    private BookService bookService;
}
