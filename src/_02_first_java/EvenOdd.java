package _02_first_java;

import java.util.Scanner;

//Write a program to print whether a number is even or odd, also take input from the user.
public class EvenOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("type a number: ");
        int number = input.nextInt();
        if(number % 2 != 0) System.out.println("Odd");
        else System.out.println("Even");
    }
}
