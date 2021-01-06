package com.aleks.administrator.cockroachdb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "cockroachdbEntityManagerFactory",
        transactionManagerRef = "cockroachdbTransactionManager"
)
public class CockroachDBConf {

    //Datasource method
    @Bean(name = "cockroachdbDatasource")
    @ConfigurationProperties(prefix = "spring.cockroachdb.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    //LocalContainerEntityManagerFactoryBean
    @Bean(name="cockroachdbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("cockroachdbDatasource") DataSource dataSource
    )
    {
        return builder
                .dataSource(dataSource)
                .packages("com.aleks.administrator.cockroachdb")
                .persistenceUnit("Cockroach")
                .build();
    }

    //PlatformTransactionManager
    @Bean(name="cockroachdbTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("cockroachdbEntityManagerFactory")EntityManagerFactory entityManagerFactory
    )
    {
        return new JpaTransactionManager(entityManagerFactory);
    }


}
