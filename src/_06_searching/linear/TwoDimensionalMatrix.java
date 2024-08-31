package _06_searching.linear;

import java.util.Arrays;

public class TwoDimensionalMatrix {
    public static void main(String[] args) {
        //this matrix is having sorted rows and sorted col
        //but is not strictly sorted
        int[][] nums = {
                {10, 20, 30, 40},
                {11, 21, 31, 41},
                {12, 22, 32, 42},
                {13, 23, 33, 43}
        };
        int target = 43;
        System.out.println(Arrays.toString(search(nums, target)));
    }
    public static int[] search(int[][] nums, int target){
        int row = 0;
        //can also work for ragged matrix where no of cols for each row is not same
        //just need to change the value if col for each row
        int col = nums.length - 1;
        while(row < nums.length && col >= 0){
            if(nums[row][col] == target){
                return new int[] {row,col};
            }
            if (nums[row][col] < target) {
                row++;
            }
            else{
                col--;
            }
        }
        return new int[] {-1,-1};
    }

}
