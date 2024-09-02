package _07_sorting.cyclic;

import java.util.ArrayList;
import java.util.List;

// LeetCode
// 448. Find All Numbers Disappeared in an Array
public class NumsDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4}; // Example input
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        cyclic(nums);
        return check(nums);
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

    private static List<Integer> check(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
