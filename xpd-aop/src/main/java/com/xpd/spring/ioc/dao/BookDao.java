package com.xpd.spring.ioc.dao;

import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository
@ToString
public class BookDao {
    private String label = "2";

    public String getLabel(){
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
