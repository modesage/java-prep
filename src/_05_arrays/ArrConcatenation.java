package _05_arrays;

import java.util.Arrays;

//leetcode
//1929. Concatenation of Array
public class ArrConcatenation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] result = getConcatenation(nums);
        System.out.println(Arrays.toString(result));

    }
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            ans[i + n] = nums[i];
        }
        return ans;
    }
}
