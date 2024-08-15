package _05_arrays;

//leetcode
//1886. Determine Whether Matrix Can Be Obtained By Rotation
public class MatrixRotation {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1},
                {1, 0}
        };
        int[][] target = {
                {1, 0},
                {0, 1}
        };
        boolean result = findRotation(mat, target);
        System.out.println(result);
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        // Check each rotation
        for (int i = 0; i < 4; i++) {
            if (areEqual(mat, target)) {
                return true;
            }
            rotate90Degrees(mat);
        }
        return false;
    }

    // Function to rotate the matrix 90 degrees clockwise in-place
    private static void rotate90Degrees(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // Function to check if two matrices are equal
    private static boolean areEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
