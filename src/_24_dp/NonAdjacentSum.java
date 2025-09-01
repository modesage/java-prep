package _24_dp;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class NonAdjacentSum {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);nums.add(4);nums.add(5);nums.add(12);nums.add(7);
        System.out.println(nonAdjacentSum(nums));
    }

    public static int nonAdjacentSum(List<Integer> nums){
        return nonAdjacentSum(nums, 0, new HashMap<>());
    }

    public static int nonAdjacentSum(List<Integer> nums, int i, HashMap<Integer, Integer> memo){
        if(i >= nums.size()){
            return 0;
        }
        if(memo.containsKey(i)){
            return memo.get(i);
        }

        int result = Math.max(nums.get(i) + nonAdjacentSum(nums, i + 2, memo) , nonAdjacentSum(nums, i + 1, memo));
        memo.put(i, result);
        return result;
    }
}
