package _24_dp;
import java.util.*;
import java.io.*;
public class ArithmeticSubArrays {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(arithmeticSubarrays(arr, n));
        }
    }
    public static int arithmeticSubarrays(int[] arr, int n) {
        if(n < 3) return 0;
        int count = 0; //no of sub arrays
        int current = 0; //the arithmetic slices end at current index
        for(int i = 2; i < n; i++){
            //found arithmetic sequence
            if(arr[i] - arr[i-1] == arr[i-1] - arr[i-2]){
                current++; //increment the current
                count += current; //update the count
            }
            //break in arithmetic sequence
            else{
                current = 0; //reset the current
            }
        }
        return count;
    }
}
/*
* if (n < 3) return 0;

        int count = 0;
        int curr = 0; // counts how many arithmetic slices end at current index

        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                curr += 1;   // extend previous sequence
                count += curr; // add new subarrays
            } else {
                curr = 0; // reset
            }
        }

        return count;
*
* */