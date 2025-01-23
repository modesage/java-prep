package _10_recursion._9_backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;  // Size of the board (4x4 in this case)
        boolean[][] board = new boolean[n][n];  // Create a board of size n x n, initialized to false
        System.out.println(queens(board, 0));  // Start solving from the first row (row 0)
    }

    // Recursive function to place queens on the board
    static int queens(boolean[][] board, int row) {
        // If we've placed queens in all rows, print the board and return 1 (solution found)
        if (row == board.length) {
            display(board);  // Display the board with queens placed
            System.out.println();  // Print a newline between different solutions
            return 1;  // Return 1, indicating a solution has been found
        }

        int count = 0;  // Variable to count the number of solutions found

        // Try placing a queen in every column of the current row
        for (int col = 0; col < board.length; col++) {
            // Check if it is safe to place the queen at position (row, col)
            if (isSafe(board, row, col)) {
                board[row][col] = true;  // Place the queen at (row, col)

                // Recursively try to place queens in the next row
                count += queens(board, row + 1);  // Add the number of solutions from the next row

                board[row][col] = false;  // Backtrack: remove the queen from (row, col)
            }
        }

        return count;  // Return the number of solutions found for this configuration
    }

    // Function to check if placing a queen at (row, col) is safe
    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check if there is any queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;  // If there's a queen in the same column, it's not safe
            }
        }

        // Check the diagonal left (top-left to bottom-right)
        int maxLeft = Math.min(row, col);  // The maximum distance to check for the diagonal
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {  // Check if there's a queen in the diagonal
                return false;  // If there's a queen in the diagonal, it's not safe
            }
        }

        // Check the diagonal right (top-right to bottom-left)
        int maxRight = Math.min(row, board.length - col - 1);  // The maximum distance to check for the diagonal
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {  // Check if there's a queen in the diagonal
                return false;  // If there's a queen in the diagonal, it's not safe
            }
        }

        // If no conflicts were found, the position is safe
        return true;
    }

    // Function to display the board with queens placed
    private static void display(boolean[][] board) {
        // Iterate over each row
        for (boolean[] row : board) {
            // Iterate over each column in the row
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");  // Print 'Q' if a queen is placed at this position
                } else {
                    System.out.print("X ");  // Print 'X' if no queen is placed at this position
                }
            }
            System.out.println();  // Print a new line after each row
        }
    }
}
