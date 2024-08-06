package _03_conditionals_loops;

import java.util.Scanner;

//Write a program to print the sum of negative numbers,
//sum of positive even numbers and the sum of positive odd numbers
//from a list of numbers (N) entered by the user.
//The list terminates when the user enters a zero.
public class UserSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int negativeSum = 0;
        int positiveOddSum = 0;
        int positiveEvenSum = 0;
        while(true){
            System.out.print("Enter a number:");
            int num = input.nextInt();
            if(num < 0){
                negativeSum += num;
            }
            else if(num > 0){
                if(num % 2 == 0){
                    positiveEvenSum += num;
                }
                else{
                    positiveOddSum += num;
                }
            }
            else{
                break;
            }
        }
        System.out.println("\nsum of negative numbers: " + negativeSum);
        System.out.println("sum of positive even numbers: " + positiveEvenSum);
        System.out.println("sum of positive odd numbers: " + positiveOddSum);
    }
}
