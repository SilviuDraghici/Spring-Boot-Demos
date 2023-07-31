package com.example.springcoredemo.springconfig;

import com.example.util.coaches.BeanCoach;
import com.example.util.coaches.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("customBeanName")
    public Coach beanCoach(){
        return new BeanCoach();
    }
}
