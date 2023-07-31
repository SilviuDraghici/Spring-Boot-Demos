package com.example.util.coaches;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

    public SoccerCoach(){
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice keep ups for ";
    }
}
