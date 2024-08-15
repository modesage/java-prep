package _05_arrays;

import java.util.Arrays;

//leetcode
//566. Reshape the Matrix
public class ReshapeMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2},
                {3,4}
        };
        int r = 1;
        int c = 4;
        int[][] result = matrixReshape(mat,r,c);
        for(int[] item : result){
            System.out.println(Arrays.toString(item));
        }
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        //checking if reshape is possible or not
        if(m * n != r * c){
            return mat;
        }
        int[] flat = new int[m*n];
        int index = 0;
        //converting array into 1d
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                flat[index++] = mat[i][j];
            }
        }
        //reshaping
        index = 0;
        int[][] newArr = new int[r][c];
        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c ; j++) {
                newArr[i][j] = flat[index++];
            }
        }
        return newArr;
    }
}