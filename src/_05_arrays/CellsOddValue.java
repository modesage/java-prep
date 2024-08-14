package _05_arrays;
//leetcode
//1252. Cells with Odd Values in a Matrix
public class CellsOddValue {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] indices = {
                {0,1},
                {1,1}
        };
        int result = oddCells(m,n,indices);
        System.out.println(result);
    }
    public static int oddCells(int m, int n, int[][] indices) {
        int[] rowIncrements = new int[m];
        int[] columnIncrements = new int[n];

        for (int[] index : indices) {
            int ri = index[0];
            int ci = index[1];
            rowIncrements[ri]++;
            columnIncrements[ci]++;
        }

        int oddCount = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int value = rowIncrements[r] + columnIncrements[c];
                if (value % 2 != 0) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }
}
