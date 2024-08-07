package _04_functions;

import java.util.Arrays;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        int[] nums = { 7, 24, 25, 8, 15, 20 };
        int numsSize = nums.length;
        if (isTriplet(nums, numsSize)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    static boolean isTriplet(int[] ar, int n) {
        int[] squares = new int[n];
        for (int i = 0; i < n; i++) {
            squares[i] = ar[i] * ar[i];
        }
        Arrays.sort(squares);

        for (int k = n - 1; k >= 2; k--) {
            int c2 = squares[k];
            int i = 0;
            int j = k - 1;

            while (i < j) {
                int sum = squares[i] + squares[j];
                if (sum == c2) {
                    return true;
                } else if (sum < c2) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return false;
    }
}
