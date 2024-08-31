package com.ssg.springex.practice;

import org.springframework.stereotype.Component;

@Component
public class MorningGreet implements Greet{


    @Override
    public void greetting() {
        System.out.println("good morning");
    }


}
