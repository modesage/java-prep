package _05_arrays;

import java.util.Arrays;

//leetcode
//66. Plus One
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i > -1 ; i--) {
            //if the digit is less than nine
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            //if the digit is nine
            digits[i] = 0;
        }
        //if all the digits are nine
        int[] overflow = new int[n+1];
        overflow[0] = 1;
        return overflow;
    }
}
