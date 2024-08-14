package _05_arrays;

import java.util.Arrays;

//leetcode
//867. Transpose Matrix
public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
        };
        int[][] result = transpose(matrix);
        for(int[] arr : result){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[cols][rows];

        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols ; col++) {
                if(row == col){
                    newMatrix[row][col] = matrix[row][col];
                }
                else{
                    newMatrix[col][row] = matrix[row][col];
                }
            }
        }
        return newMatrix;
    }
}
