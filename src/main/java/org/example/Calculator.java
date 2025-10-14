package org.example;

public class Calculator {

    private Calculator(){

    }

    public static int add(String value){
        if(value.isEmpty()) return 0;
        if(value.length() == 1) return Integer.parseInt(value);
        String[] nums = value.split(",");
        return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
    }

}
