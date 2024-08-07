package _04_functions;

import java.util.Scanner;

public class PrimeComposite {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        if(num <= 1) System.out.println("neither Prime nor Composite!");
        else if (num == 2){
            System.out.println("Prime");
        }
        else{
            String result = checker(num);
            System.out.println(result);
        }
    }
    static String checker(int num){
        int n = 3;
        if(num % 2 == 0) return "Composite";
        while(n * n <= num){
            if(num % n == 0) return "Composite";
            n += 2;
        }
        return "Prime";
    }
}
