package com.example.WhizzRecipe.configuration;

import javax.sql.DataSource;
import   org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseConfiguration {

    @Bean(name = "mySQL")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {

        return DataSourceBuilder.create().build();
    }

    // Below is to initialise jpa properties if needed
    @Bean
    @ConfigurationProperties(prefix = "spring.jpa")
    public JpaProperties jpaProperties() {
        JpaProperties properties = new JpaProperties();
        return properties;
    }

}