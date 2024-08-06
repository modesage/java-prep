package _03_conditionals_loops;

import java.util.Scanner;
//leetcode
//1281. Subtract the Product and Sum of Digits of an Integer
public class SubtractProductAndSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = input.nextInt();
        int result = subProductAndSum(num);
        System.out.println("Result: " + result);
    }
    public static int subProductAndSum(int num){
        //return the difference btw
        //product of digits
        //sum of digits
        int product = 1;
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            product *= rem;
            sum += rem;
            num /= 10;
        }
        return (product - sum);
    }
}
