package _05_arrays;
//leetcode
//1295. Find Numbers with Even Number of Digits
public class NumsWithEvenDigits {
    public static void main(String[] args) {
        int[] nums = {1,12,3,534,123,34,3543};
        int result = findNumbers(nums);
        System.out.println(result);
    }
    public static int findNumbers(int[] nums) {
        int evenDigits = 0;
        for (int i = 0; i < nums.length ; i++) {
            int digits = 0;
            while(nums[i] > 0){
                digits++;
                nums[i] /= 10;
            }
            if(digits % 2 == 0) evenDigits++;
        }
        return evenDigits;
    }
}
