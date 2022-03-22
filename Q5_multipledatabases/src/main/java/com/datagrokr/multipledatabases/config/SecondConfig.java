package com.datagrokr.multipledatabases.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
        basePackages = "com.datagrokr.multipledatabases.dao.seconddatabaserepo",
        entityManagerFactoryRef = "secondEntityManager",
        transactionManagerRef = "secondTransactionManager"
)
public class SecondConfig {

    @Autowired
    private Environment env;

    public SecondConfig(){
        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManager() {
        LocalContainerEntityManagerFactoryBean em1
                = new LocalContainerEntityManagerFactoryBean();
        em1.setDataSource(secondDataSource());
        em1.setPackagesToScan(
                new String[] { "com.datagrokr.multipledatabases.entity.seconddatabase" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em1.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        em1.setJpaPropertyMap(properties);

        return em1;
    }

    @Bean
    public DataSource secondDataSource() {

        DriverManagerDataSource dataSource2
                = new DriverManagerDataSource();
        dataSource2.setDriverClassName(
                env.getProperty("spring.second.datasource.driver-class-name"));
        dataSource2.setUrl(env.getProperty("spring.second.datasource.url"));
        dataSource2.setUsername(env.getProperty("spring.second.datasource.username"));
        dataSource2.setPassword(env.getProperty("spring.second.datasource.password"));

        return dataSource2;
    }

    @Bean
    public PlatformTransactionManager secondTransactionManager() {

        JpaTransactionManager transactionManager2
                = new JpaTransactionManager();
        transactionManager2.setEntityManagerFactory(
                secondEntityManager().getObject());
        return transactionManager2;
    }

}
