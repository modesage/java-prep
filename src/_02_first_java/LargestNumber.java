package _02_first_java;

import java.util.Scanner;

//Take 2 numbers as input and print the largest number.
public class LargestNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        double number1 = input.nextDouble();
        System.out.print("Enter number 2: ");
        double number2 = input.nextDouble();

        if(number1 > number2){
            System.out.println(number1 + " is the largest number");
        }
        else if(number2 > number1){
            System.out.println(number2 + " is the largest number");
        }
        else{
            System.out.println(number1 + " is equal to " + number2);
        }
    }
}
