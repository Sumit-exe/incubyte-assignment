package org.example;

public class Calculator {

    private Calculator(){

    }

    public static int add(String value){
        int sum = 0;
        if(value.isEmpty()) return sum;
        String[] nums = value.split("[,\n]");
        for(String num : nums){
            sum +=Integer.parseInt(num);
        }
        return sum;
    }

}
