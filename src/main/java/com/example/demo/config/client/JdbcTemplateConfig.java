package com.example.demo.config.client;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.example.demo.config.variable.ApplicationConstant;

@Configuration
public class JdbcTemplateConfig {

	@Autowired
    @Qualifier(ApplicationConstant.BEAN_DATASOURCE_USER)
    private DataSource dataSource;

    @Bean(ApplicationConstant.BEAN_JDBC_USER)
    public JdbcTemplate initJdbc() {
        return new JdbcTemplate(dataSource);
    }

    @Autowired
    @Qualifier(ApplicationConstant.BEAN_TRANSACTION_MANAGER)
    @Bean(ApplicationConstant.BEAN_TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(ApplicationConstant.BEAN_TRANSACTION_TEMPLATE)
    public TransactionTemplate transactionTemplate() {
        return new TransactionTemplate(transactionManager());
    }
    
}
