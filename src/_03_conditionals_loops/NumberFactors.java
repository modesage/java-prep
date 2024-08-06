package _03_conditionals_loops;

import java.util.Scanner;

//Input a number and print all the factors of that number (use loops).
public class NumberFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        System.out.println("factors of " + num);
        factors(num);
        input.close();
    }
    public static void factors(int num){
        for (int i = 1; i <=num ; i++) {
            if(num % i == 0){
                System.out.print(i + " ");
            }
        }
    }
}
