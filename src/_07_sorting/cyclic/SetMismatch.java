package _07_sorting.cyclic;

import java.util.Arrays;

//leetcode
//645. Set Mismatch
public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }
    public static int[] findErrorNums(int[] nums) {
        int[] arr = new int[2];
        cyclic(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                arr[0] = nums[i];
                arr[1] = i + 1;
            }
        }
        return arr;
    }
    static void cyclic(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }
    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
