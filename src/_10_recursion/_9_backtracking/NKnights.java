package _10_recursion._9_backtracking;

public class NKnights {
    public static void main(String[] args) {
        // Size of the chessboard (n x n) and the number of knights to place
        int n = 4;
        boolean[][] board = new boolean[n][n];  // Create an empty n x n chessboard
        System.out.println(knight(board, 0, 0, n));  // Start the recursive knight placement from the top-left corner (0, 0)
    }

    // Recursive function to place knights on the board
    static int knight(boolean[][] board, int row, int col, int knights) {
        // Base case: If no more knights need to be placed, display the board and return
        if (knights == 0) {
            display(board);  // Print the current board configuration
            System.out.println();  // Add a blank line after displaying the board
            return 1;  // Return 1 for a valid solution found
        }

        // If we've reached the end of the board without placing all knights, return 0 (no solution)
        if (row == board.length - 1 && col == board.length) {
            return 0;
        }

        // If we've reached the end of a column, move to the next row and reset column index to 0
        if (col == board.length) {
            return knight(board, row + 1, 0, knights);  // Start the next row from the first column
        }

        int count = 0;

        // If the current position is safe, place the knight and try placing the remaining knights
        if (isSafe(board, row, col)) {
            board[row][col] = true;  // Place the knight at (row, col)
            count += knight(board, row, col + 1, knights - 1);  // Place the next knight and continue
            board[row][col] = false;  // Backtrack: remove the knight from (row, col)
        }

        // Try the next position without placing a knight at the current (row, col)
        count += knight(board, row, col + 1, knights);  // Continue with the next position

        return count;  // Return the total number of valid configurations found
    }

    // Check if it's safe to place a knight at position (row, col)
    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check if placing a knight at (row, col) will result in an attack from any other knight
        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
            return false;  // Attack from the knight at (row-2, col-1)
        }

        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
            return false;  // Attack from the knight at (row-1, col-2)
        }

        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) {
            return false;  // Attack from the knight at (row-2, col+1)
        }

        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
            return false;  // Attack from the knight at (row-1, col+2)
        }

        return true;  // No attacks detected, safe to place the knight
    }

    // Helper function to check if a given position is within the bounds of the board
    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;  // Ensure row and col are within the board limits
    }

    // Function to display the current configuration of the chessboard
    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                // Print 'K' if there's a knight at the position, 'X' if the position is empty
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();  // Print a new line after each row
        }
    }
}
