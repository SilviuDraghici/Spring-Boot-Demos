package com.example.util.coaches;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// this makes the class not a singleton
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennisCoach implements Coach {

    public TennisCoach(){
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
        return "Practice with Maria Sharapova and Steve for ";
    }
}
