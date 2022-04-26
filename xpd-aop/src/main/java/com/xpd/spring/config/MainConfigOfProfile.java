package com.xpd.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource(value = {"classpath:/config/db.properties"})
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
    @Value("${datasource.username}")
    private String username;

    private String driver;
    private StringValueResolver stringValueResolver;

    @Profile("default")
    @Bean("dataSourceTest")
    public DataSource dataSourceTest(@Value("${datasource.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/iorl");
        return dataSource;
    }

    @Profile("dev")
    @Bean("dataSourceDev")
    public DataSource dataSourceDev(@Value("${datasource.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/iorl");
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
        driver = stringValueResolver.resolveStringValue("${datasource.driver}");
    }
}
