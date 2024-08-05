package _02_first_java;

import java.util.Scanner;

//To find Armstrong Number between two given number.
public class Armstrong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number1: ");
        int number1 = input.nextInt();
        System.out.print("Enter number2: ");
        int number2 = input.nextInt();

        for (int num = number1; num <= number2; num++) {
            int originalNum = num;
            int sum = 0;
            //number of digits in the number
            int power = String.valueOf(num).length();

            while (num > 0) {
                int digit = num % 10;
                sum += (int) Math.pow(digit, power);
                num /= 10;
            }

            if (sum == originalNum) {
                System.out.println(originalNum + " is an Armstrong number.");
            }

            //restoring the original number for the next iteration
            num = originalNum;
        }

        input.close();
    }
}
