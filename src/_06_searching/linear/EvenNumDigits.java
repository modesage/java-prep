package _06_searching.linear;
//leetcode
//1295. Find Numbers with Even Number of Digits
public class EvenNumDigits {
    public static void main(String[] args) {
        int[] nums = {551,9201,482,1771};
        int result = findNumbers(nums);
        System.out.println(result);
    }
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            int currentDigits = (int) Math.log10(num) + 1;
            if(currentDigits % 2 == 0) count++;
        }
        return count;
    }
}

