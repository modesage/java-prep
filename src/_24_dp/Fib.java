package _24_dp;

import java.util.HashMap;
import java.util.Scanner;

public class Fib {
    public static void main(String[] args){
        HashMap<Integer, Integer> memo = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
//        int result = fibWithoutMemo(n);
//        int result = fibWithMemo(n, memo);
//        int result = fibBottomUp(n);
        int result = fibOptimized(n);
        System.out.print("result: " + result);
        sc.close();
    }
    public static int fibWithoutMemo(int n){
        if(n < 0){
            System.out.println("Negative input is not allowed.");
            return 0;
        }
        else if(n == 0 || n == 1){
            return n;
        }
        return fibWithoutMemo(n-1) + fibWithoutMemo(n-2);
    }
    //memoization (top-down approach -> hashmap )
    public static int fibWithMemo(int n, HashMap<Integer, Integer> memo){
        if(n < 0){
            System.out.println("Negative input is not allowed.");
            return 0;
        }
        else if(n == 0 || n == 1){
            return n;
        }
        else if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = fibWithMemo(n - 1, memo) + fibWithMemo(n - 2, memo);
        memo.put(n, result);
        return result;
    }
    //iterative (bottom-up approach -> array)
    public static int fibBottomUp(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    //most optimized approach
    public static int fibOptimized(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
