package com.xpd.spring.bean;

import lombok.ToString;

@ToString
public class Car {

    private String type;

    public Car() {
        System.out.println("car constructor...");
        this.type = "吉普";
    }

    public void init() {
        System.out.println("Car...init....");
        this.type = "五菱宏光";
    }

    public void destroy() {
        System.out.println("Car...destroy....");
    }
}
