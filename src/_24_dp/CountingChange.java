package _24_dp;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CountingChange {
    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);coins.add(2);coins.add(3);
        int amount = 4;
        System.out.println(countingChange(amount, coins));
    }
    public static int countingChange(int amount, List<Integer> coins){
        return countingChange(amount, 0, coins, new HashMap<>());
    }
    public static int countingChange(int amount, int coinIdx , List<Integer> coins, HashMap<List<Integer>, Integer> memo){
        //as there is only 1 way to return 0 amount
        if(amount == 0){
            return 1;
        }

        if(coinIdx >= coins.size()){
            return 0;
        }

        List<Integer> key = List.of(amount, coinIdx);
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int value = coins.get(coinIdx);
        int totalWays = 0;
        for(int qty = 0; qty * value <= amount; qty++){
            int subAmount = amount - (qty * value);
            totalWays += countingChange(subAmount, coinIdx + 1, coins, memo);
        }

        memo.put(key, totalWays);
        return totalWays;
    }
}
