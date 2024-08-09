package _05_arrays;

import java.util.Arrays;

//leetcode
//1470. Shuffle the Array
public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,4,6};
        int n = 3;
        int[] result = shuffle(nums, n);
        System.out.println(Arrays.toString(result));
    }
    public static int[] shuffle(int[] nums, int n) {
        int[] shuffledArr = new int[2*n];
        int prev = 0;
        int next = n;
        for (int i = 0; i < 2*n ; i += 2) {
            shuffledArr[i] = nums[prev++];
            shuffledArr[i+1] = nums[next++];
        }
        return shuffledArr;
    }
}
