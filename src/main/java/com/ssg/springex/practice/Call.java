package com.ssg.springex.practice;

public class Call {
    public static void main(String[] args) {
        Calculator cal = new AddCalc();
        Integer result = cal.cal(5, 10);
        System.out.println(result);

/*        Calculator cal = new SubCalc();
        Integer result = cal.cal(5, 10);
        System.out.println(result);*/




    }
}
