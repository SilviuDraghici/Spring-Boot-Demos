package com.example.springbootmvccrud.dao;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    /*@Bean
    @ConfigurationProperties(prefix="spring.student-tracker")
    public DataSource studentTrackerDataSource() {
        return DataSourceBuilder.create().build();
    }*/

    /*@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }*/
}
