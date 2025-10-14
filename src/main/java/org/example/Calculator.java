package org.example;

public class Calculator {

    private Calculator(){

    }

    public static int add(String value){
        if(value.isEmpty()) return 0;
        return Integer.parseInt(value);
    }

}
