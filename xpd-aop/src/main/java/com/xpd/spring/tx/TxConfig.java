package com.xpd.spring.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 开启事务：
 * 1. @EnableTransactionManagement
 * 2.
 */
@EnableTransactionManagement
@Configuration
@PropertySource(value = {"classpath:/config/db.properties"})
@ComponentScan(value = "com.xpd.spring.tx")
public class TxConfig /*implements TransactionManagementConfigurer*/ {
    @Value("${datasource.username}")
    private String user;
    @Value("${datasource.password}")
    private String passWord;
    @Value("${datasource.driver}")
    private String driver;
    @Value("${datasource.url}")
    private String url;

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(passWord);
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        return new JdbcTemplate(dataSource());
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    /*@SneakyThrows
    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }*/
}
