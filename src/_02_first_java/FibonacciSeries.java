package _02_first_java;

import java.util.Scanner;

// To calculate Fibonacci Series up to n numbers.
public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Series up to terms: ");
        int limit = input.nextInt();

        if (limit <= 0) {
            System.out.println("The number of terms must be positive.");
        } else if (limit == 1) {
            System.out.println("Fibonacci Series up to " + limit + " term: \n0");
        } else {
            printFibonacciSeries(limit);
        }

        input.close();
    }

    public static void printFibonacciSeries(int n) {
        int term1 = 0;
        int term2 = 1;

        System.out.println("Fibonacci Series up to " + n + " terms:");

        if (n >= 1) {
            System.out.print(term1);
        }
        if (n >= 2) {
            System.out.print(", " + term2);
        }

        for (int i = 3; i <= n; i++) {
            int nextTerm = term1 + term2;
            System.out.print(", " + nextTerm);
            term1 = term2;
            term2 = nextTerm;
        }
        System.out.println();
    }
}
