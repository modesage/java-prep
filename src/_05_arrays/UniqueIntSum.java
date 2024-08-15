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
        if(n % 2 != 0){
            sum[0] = 0;
            int j = 1;
            for (int i = 1; i < sum.length ; i += 2) {
                sum[i] = j;
                sum[i+1] = -j;
                j++;
            }
        }
        else{
            int j = 1;
            for (int i = 0; i < sum.length ; i += 2) {
                sum[i] = j;
                sum[i+1] = -j;
                j++;
            }
        }
        return sum;
    }
}
