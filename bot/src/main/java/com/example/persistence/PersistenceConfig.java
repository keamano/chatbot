package com.example.persistence;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:jdbc.properties")
public class PersistenceConfig {

    @Bean
    public DataSource dataSource(@Value("${jdbc.driverClassName}") String driverClassName,
            @Value("${jdbc.url}") String url, @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        return jdbcTemplate;
    }

}
