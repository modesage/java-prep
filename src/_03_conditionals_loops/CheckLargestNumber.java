package _03_conditionals_loops;

import java.util.Scanner;

// Take integer inputs till the user enters 0 and print the largest number from all.
public class CheckLargestNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        boolean hasValidInput = false;

        while (true) {
            System.out.print("Enter a number: ");
            int num = input.nextInt();

            if (num == 0) {
                break;
            }

            if (num > max) {
                max = num;
                hasValidInput = true;
            }
        }

        input.close();

        if (hasValidInput) {
            System.out.println("\nLargest Number: " + max);
        } else {
            System.out.println("No valid numbers were entered.");
        }
    }
}
