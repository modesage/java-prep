package _05_arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode
//1. Two Sum
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int[] nums, int target) {
        //brute force
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length-1 ; i++) {
//            for (int j = i+1; j < nums.length ; j++) {
//                if(target == nums[i] + nums[j]){
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        return result;

        //optimized
        // Create a map to store the number and its index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // Return the indices of the two numbers that add up to target
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // Throw an exception if no solution is found
        throw new IllegalArgumentException("No two sum solution");
    }
}
