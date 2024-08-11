package _05_arrays;

import java.util.Arrays;

//leetcode
//1365. How Many Numbers Are Smaller Than the Current Number
public class SmallerThanCurrentNumber {
    public static void main(String[] args) {
        int[] nums = {6,5,4,8};
        int[] result = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(result));
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            int count = 0;
            for (int j = 0; j < nums.length ; j++) {
                if (nums[i] > nums[j]) {
                    count += 1;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
