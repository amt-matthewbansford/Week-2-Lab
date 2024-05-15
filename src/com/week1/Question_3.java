package com.week1;

public class Question_3 {
    public static void main(String[] args) {
//        Declaring age as a variable
        int age = 15;

//        1. If Statement for age
        if (age >= 18) {
            System.out.println("You're an adult");
        } else {
            System.out.println("You're a minor");
        }


//        2. Switch Case conditional
        switch (age){
            case 12:
                System.out.println("You are a child");
            break;
            case 19:
                System.out.println("You are a teenager");
            break;
            case 59:
                System.out.println("You are an adult");
            break;
            default:
                if (age >= 60) {
                    System.out.println("You are a senior citizen");
                } else {
                    System.out.println("Invalid age.");
                }
            break;
        }

//        3. For loop to print 1-10
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(i);
        }

//        4. Nested Loop (Square pattern)
        int size = 4;

        for(int i = 1; i <= size; i++) {
            for (int j = 1; j <= size ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


//        5. Creating a while loop to countdown from 10 to 1
            int count = 10;

        while (count >= 1) {
            System.out.println(count);
            count--;
        }
    }
}