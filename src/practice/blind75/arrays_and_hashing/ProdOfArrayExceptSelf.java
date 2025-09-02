package practice.blind75.arrays_and_hashing;
//https://leetcode.com/problems/product-of-array-except-self/description/
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//You must write an algorithm that runs in O(n) time and without using the division operation.

//time: O(N)
//space: O(1)
public class ProdOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //product of left prefix of i * product of right suffix of i
        int n = nums.length;
        int[] result = new int[n];
        //building prefix product
        result[0] = 1;
        for(int i = 1; i < n; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }
        //build suffix product
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--){
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }
        return result;
    }
}
