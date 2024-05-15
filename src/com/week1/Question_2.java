package com.week1;

public class Question_2 {
    public static void printNameDetails(String firstname, String lastname) {
//        Declaring fullName variable
        String fullName = firstname + ' ' + lastname;

//        Declaring firstname & Lastname lengths
        int firstNameLength = firstname.length();
        int lastNameLength = lastname.length();

//        Printing the details of printNameDetails
        System.out.printf("Hello, my name is %s.%nThere are %d letters in my first name and %d letters in my last name.%n",
                            fullName,firstNameLength,lastNameLength);
    }

    public static void main(String[] args) {
//        Printing out the result text
        printNameDetails("Matthew", "Bansford");
    }
}
