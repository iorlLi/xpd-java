package com.xpd.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    /*
        SpEl表达式:@Value("#{3 + 1}")
     */
    @Value("xpd")
    private String name;
    @Value("#{3 + 1}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;
}
