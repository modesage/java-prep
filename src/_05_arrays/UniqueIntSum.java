package _05_arrays;

import java.util.Arrays;

//leetcode
//1304. Find N Unique Integers Sum up to Zero
public class UniqueIntSum {
    public static void main(String[] args) {
        int n = 5;
        int[] result = sumZero(n);
        System.out.println(Arrays.toString(result));
    }
    public static int[] sumZero(int n) {
        int[] sum = new int[n];
        int j = 1;

        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n) {
                sum[i] = j;
                sum[i + 1] = -j;
            } else {
                sum[i] = 0;
            }
            j++;
        }

        return sum;
    }
}
