package com.datagrokr.multipledatabases.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackages = "com.datagrokr.multipledatabases.dao.firstdatabaserepo",
        entityManagerFactoryRef = "firstEntityManager",
        transactionManagerRef = "firstTransactionManager"
)
public class FirstConfig {


        @Autowired
        private Environment env;

    public FirstConfig() {
        super();
    }

        @Bean
        @Primary
        public LocalContainerEntityManagerFactoryBean firstEntityManager() {
            LocalContainerEntityManagerFactoryBean em
                    = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(firstDataSource());
            em.setPackagesToScan(
                    new String[] { "com.datagrokr.multipledatabases.entity.firstdatabase" });

            HibernateJpaVendorAdapter vendorAdapter
                    = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);
            HashMap<String, Object> properties = new HashMap<>();
            properties.put("hibernate.hbm2ddl.auto",
                    env.getProperty("hibernate.hbm2ddl.auto"));
            properties.put("hibernate.dialect",
                    env.getProperty("hibernate.dialect"));
            em.setJpaPropertyMap(properties);

            return em;
        }

        @Primary
        @Bean
        public DataSource firstDataSource() {

            DriverManagerDataSource dataSource
                    = new DriverManagerDataSource();
            dataSource.setDriverClassName(
                    env.getProperty("spring.first.datasource.driver-class-name"));
            dataSource.setUrl(env.getProperty("spring.first.datasource.url"));
            dataSource.setUsername(env.getProperty("spring.first.datasource.username"));
            dataSource.setPassword(env.getProperty("spring.first.datasource.password"));

            return dataSource;
        }

//        @Primary
        @Bean
        public PlatformTransactionManager firstTransactionManager() {

            JpaTransactionManager transactionManager
                    = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(
                    firstEntityManager().getObject());
            return transactionManager;
        }
    }
