package _05_arrays;
//leetcode
//1572. Matrix Diagonal Sum
public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}
        };
        int result = diagonalSum(mat);
        System.out.println(result);
    }
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int k = mat.length-1;
        int middle = mat.length / 2;
        for (int i = 0; i < mat.length ; i++) {
            for (int j = i; j == i ; j++) {
                if(mat.length % 2 == 0){
                    sum += mat[i][j] + mat[i][k];
                }
                else{
                    if(i == middle){
                        sum += mat[i][j];
                    }
                    else{
                        sum += mat[i][j] + mat[i][k];
                    }
                }
                k--;
            }
        }
        return sum;
    }
}


