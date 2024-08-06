package _03_conditionals_loops;

import java.util.Scanner;
//find factorial of a number
public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        if(num >= 0){
            int factorial = 1;
            for (int i = num; i > 1 ; i--) {
                factorial *= i;
            }
            System.out.println("factorial: " + factorial);
        }
        else{
            System.out.println("factorial for negative numbers is not defined!");
        }
    }
}
