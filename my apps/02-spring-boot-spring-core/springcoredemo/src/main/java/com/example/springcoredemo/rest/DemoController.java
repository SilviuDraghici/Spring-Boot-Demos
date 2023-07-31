package com.example.springcoredemo.rest;

import com.example.util.coaches.Coach;
import com.example.util.DurationSetter;
import com.example.util.FieldInjectionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;
    private Coach otherCoach;
    private Coach setterCoach;
    private DurationSetter ds;

    //field injection is not recommended because it makes unit testing harder
    @Autowired
    private FieldInjectionExample fieldInjectionObject;

    @Autowired
    public DemoController(@Qualifier("customBeanName") Coach coach,
                          @Qualifier("tennisCoach") Coach otherCoach){
        System.out.println("Initializing " + getClass().getSimpleName());
        this.coach = coach;
        this.otherCoach = otherCoach;
    }

    @Autowired
    public void setDs_randFuncName(DurationSetter ds) {
        this.ds = ds;
    }

    @Autowired
    public void setSetterCoach(Coach setterCoach) {
        this.setterCoach = setterCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return this.coach.getDailyWorkout() + this.ds.returnDuration() +
               this.fieldInjectionObject.returnHTMLString() +
               "<br>Other Coach says: " + this.setterCoach.getDailyWorkout() + this.ds.returnDuration();
    }
}
