package _07_sorting.cyclic;

import java.util.ArrayList;
import java.util.List;

//leetcode
//442. Find All Duplicates in an Array
public class DuplicatesInArray {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        cyclic(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                list.add(nums[i]);
            }
        }
        return list;
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
