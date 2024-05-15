package com.week1;

public class Question_1 {
    public static void main(String[] args) {
//        Declaring Integer Variable
        int bankBalance = 500;

//        Operations (Add 250)
        bankBalance += 250;

//        Subtract 100
        bankBalance -= 100;

//        Printing results
        System.out.println(bankBalance);

//        Defining a double variable
        double fahreinheit = 50;

//        Declare another double called celsius
        double celsius = (fahreinheit -= 32) * 5 / 9;

//        Printing final value of celsius
        System.out.println(celsius);

    }
}
