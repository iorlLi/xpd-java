package com.xpd.spring.ioc;

import com.xpd.spring.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IocTest_Profile {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext apc =
                new AnnotationConfigApplicationContext();
        apc.getEnvironment().setActiveProfiles("dev");
        apc.register(MainConfigOfProfile.class);
        apc.refresh();

        String[] beanNamesForType = apc.getBeanNamesForType(DataSource.class);
        for (String name : beanNamesForType) {
            System.out.println(name);

        }
    }
}
