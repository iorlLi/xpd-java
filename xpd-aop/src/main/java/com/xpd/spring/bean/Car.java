package com.xpd.spring.bean;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Car {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.get("a"));
    }
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
