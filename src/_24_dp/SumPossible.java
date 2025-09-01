package _24_dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SumPossible {
    public static void main(String[] args) {
        int amount = 15;
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1); numbers.add(2); numbers.add(3);
        System.out.println(sumPossible(amount, numbers));
    }
    public static boolean sumPossible(int amount, List<Integer> numbers){
        return sumPossible(amount, numbers, new HashMap<>());
    }
    public static boolean sumPossible(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo){
        if(amount == 0) return true;
        if(amount < 0) return false;
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        for(int num : numbers){
            int subAmount = amount - num;
            if(sumPossible(subAmount, numbers, memo)){
                memo.put(amount, true);
                return true;
            }
        }
        memo.put(amount, false);
        return false;
    }

}
