package practice.blind75.arrays_and_hashing;
//https://leetcode.com/problems/two-sum/description/
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(hm.containsKey(complement)){
                return new int[]{hm.get(complement), i};
            }
            hm.put(nums[i], i);
        }
        return new int[]{};
    }
}
