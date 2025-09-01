package _24_dp;

import java.util.HashMap;

public class Tribonacci {
    public static void main(String[] args) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println("result: " + tribo(8, memo));
    }
    public static int tribo(int n, HashMap<Integer, Integer> memo){
        if(n < 0){
            System.out.println("negative numbers not allowed");
            return 0;
        }
        else if(n == 0){
            return 0;
        }
        else if(n == 1 || n == 2){
            return 1;
        }
        else if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = tribo(n - 1, memo) + tribo(n - 2, memo) + tribo(n - 3, memo);
        memo.put(n, result);
        return result;
    }
}
