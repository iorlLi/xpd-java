package com.xpd.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void insert(){
        userDao.insert();
        System.out.println("insert finish ......");
        //int i = 17 / 0;
    }
}
