package _05_arrays;
//leetcode
//1512. Number of Good Pairs
public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int result = numIdenticalPairs(nums);
        System.out.println(result);
    }
    public static int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        for (int i = 0; i < nums.length-1 ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[i] == nums[j]){
                    goodPairs += 1;
                }
            }

        }
        return goodPairs;
    }
}
