package _02_first_java;

// Write a program to input principal, time, and rate (P, T, R) from the user and find Simple Interest.
import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double principalAmount = input.nextDouble();

        System.out.print("Enter rate of interest (in percentage): ");
        double interestRate = input.nextDouble();

        System.out.print("Enter time (in years): ");
        double timeYears = input.nextDouble();

        double simpleInterest = (principalAmount * interestRate * timeYears) / 100;

        System.out.println("Simple Interest: " + simpleInterest);

        input.close();
    }
}
