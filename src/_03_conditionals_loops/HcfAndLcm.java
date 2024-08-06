package _03_conditionals_loops;

import java.util.Scanner;

//find the hcf and lcm of two numbers
public class HcfAndLcm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = input.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = input.nextInt();

        int numsHcf = hcf(num1, num2);
        System.out.println("HCF: " + numsHcf);
        int numsLcm = lcm(num1, num2, numsHcf);
        System.out.println("LCM: " + numsLcm);
    }
    public static int hcf(int num1, int num2){
        while(num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
    public static int lcm(int num1, int num2, int numsHcf){
        return (( num1 * num2 ) / numsHcf);
    }
}
