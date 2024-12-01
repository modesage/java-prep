package _10_recursion;

import java.util.HashMap;

public class FibonacciOptimized {
    // Memoization map to store previously computed Fibonacci values
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int num = 40;
        int result = fibo(num);
        System.out.println(result);
    }

    static int fibo(int num) {
        if (num < 0) {
            return -1; // Error case: Fibonacci numbers are not defined for negative indices
        }

        // Check if the Fibonacci number has already been computed
        if (memo.containsKey(num)) {
            return memo.get(num); // Return the memoized value
        }

        // Base cases
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }

        // Recursive case: Compute and store the result in the memo map
        int result = fibo(num - 1) + fibo(num - 2);
        memo.put(num, result);  // Memoize the result
        return result;
    }
}
