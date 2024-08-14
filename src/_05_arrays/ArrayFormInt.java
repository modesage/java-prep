package _05_arrays;

import java.util.ArrayList;
import java.util.List;

//leetcode
//989. Add to Array-Form of Integer
public class ArrayFormInt {
    public static void main(String[] args) {
        int[] num = {9,9,9,9,9,9,9,9,9,9};
        int k = 1;
        List<Integer> result = addToArrayForm(num, k);
        System.out.println(result);
    }
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];  // Add the current digit to k
            }
            result.addFirst(k % 10);  // Get the last digit of k and add it to the front of list
            k /= 10;  // Remove the last digit from k
            i--;
        }
        return result;
    }
}
