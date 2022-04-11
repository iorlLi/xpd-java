package com.xpd.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * 导入类的全限名数组
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        System.out.println("###########################");
        System.out.println(annotationTypes);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return new String[]{"com.xpd.spring.bean.Red", "com.xpd.spring.bean.Color", "com.xpd.spring.bean.Green"};
    }
}
