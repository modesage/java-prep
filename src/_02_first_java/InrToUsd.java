package _02_first_java;

import java.util.Scanner;

//Input currency in rupees and output in USD.
public class InrToUsd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the currency in rupees: ");
        double rupees = input.nextDouble();
        double convertedAmount = rupees * 0.01193;
        System.out.println(rupees + " rupees = " + convertedAmount + " usd");
    }
}
