package _24_dp;

import java.util.HashMap;

public class SummingSquares {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(summingSquares(n));
    }

    public static int summingSquares(int n){
        return (int) summingSquares(n, new HashMap<>());
    }

    public static double summingSquares(int n, HashMap<Integer, Double> memo){
        if(n == 0) return 0;
        double minSquares = Double.POSITIVE_INFINITY;
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        for(int i = 1; i <= Math.sqrt(n); i++   ){
            int square = i * i;
            double numSquares = 1 + summingSquares(n - square, memo);
            if(numSquares < minSquares){
                minSquares = numSquares;
            }
        }

        memo.put(n, minSquares);
        return minSquares;
    }
}
