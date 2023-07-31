package com.example.util.coaches;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

public class BeanCoach implements Coach {

    public BeanCoach(){
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doStuffConstruct(){
        System.out.println("Post Construct for " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doStuffDestruct(){
        System.out.println("Pre Destroy for " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "This is an example of @configuration and @Bean for ";
    }
}
