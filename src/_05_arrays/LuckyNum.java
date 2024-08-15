package _05_arrays;

import java.util.ArrayList;
import java.util.List;

//leetcode
//1380. Lucky Numbers in a Matrix
public class LuckyNum {
    public static void main(String[] args) {
        int[][] matrix = {
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };
        List<Integer> result = luckyNumbers(matrix);
        System.out.println(result);
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        for (int i = 0; i < numRows; i++) {
            int minInRow = matrix[i][0];
            int minColIndex = 0;
            for (int j = 1; j < numCols; j++) {
                if (matrix[i][j] < minInRow) {
                    minInRow = matrix[i][j];
                    minColIndex = j;
                }
            }

            boolean isLucky = true;
            for (int k = 0; k < numRows; k++) {
                if (matrix[k][minColIndex] > minInRow) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                result.add(minInRow);
            }
        }
        return result;
    }
}
