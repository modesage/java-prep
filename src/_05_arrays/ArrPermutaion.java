package _05_arrays;

import java.util.Arrays;

//leetcode
//1920. Build Array from Permutation
public class ArrPermutaion {
    public static void main(String[] args) {
        int[] nums = {5,0,1,2,3,4};
        int[] result = buildArray(nums);
        System.out.println(Arrays.toString(result));

    }
//    public static int[] buildArray(int[] nums) {
//        int n = nums.length;
//        int[] ans = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            ans[i] = nums[nums[i]];
//        }
//
//        return ans;
//    }

    //In-Place Encoding and Decoding Approach
    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        // Encoding both the original value and the result into the nums array
        for (int i = 0; i < n; i++) {
            // Encode the result into nums[i]
            int original = nums[i]; // This will be used to fetch the new value
            int result = nums[original] % n; // Get the result part
            nums[i] = nums[i] + result * n; // Store both original and result
        }
        // Decoding the result from the encoded values
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n; // Extract the result part
        }
        return nums;
    }
}
