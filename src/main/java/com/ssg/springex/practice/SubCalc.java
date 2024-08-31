package com.ssg.springex.practice;

public class SubCalc implements Calculator{
    @Override
    public Integer cal(Integer x, Integer y) {
        return x - y;
    }
}
