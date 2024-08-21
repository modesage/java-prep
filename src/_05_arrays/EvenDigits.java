package _05_arrays;
//leetcode
//1295. Find Numbers with Even Number of Digits
public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {555,901,482,1771};
        int result = findNumbers(nums);
        System.out.println(result);
    }
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length ; i++) {
            int digits = 0;
            while(nums[i] > 0){
                nums[i] /= 10;
                digits++;
            }
            if(digits % 2 == 0) count++;
        }
        return count;
    }
}
