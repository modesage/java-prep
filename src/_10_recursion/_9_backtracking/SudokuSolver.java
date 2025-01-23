package _10_recursion._9_backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        // Initial board setup (0 represents empty cells)
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        // Try to solve the Sudoku and display the solution if possible
        if (solve(board)) {
            display(board);  // Display the solved board
        } else {
            System.out.println("Cannot solve");  // If no solution exists
        }
    }

    // Recursive function to solve the Sudoku puzzle
    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1, col = -1;
        boolean emptyLeft = true;

        // Search for the first empty cell (represented by 0)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) break;  // Break if an empty spot is found
        }

        // If no empty cells are left, the Sudoku is solved
        if (emptyLeft) return true;

        // Try placing numbers 1-9 in the empty cell
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;  // Place the number in the cell
                if (solve(board)) return true;  // Continue solving recursively
                board[row][col] = 0;  // Backtrack if placing the number doesn't work
            }
        }
        return false;  // Return false if no valid number can be placed
    }

    // Display the Sudoku board in a readable format
    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");  // Print each number in the row
            }
            System.out.println();  // Move to the next line after each row
        }
    }

    // Check if it is safe to place a number at the given row and column
    static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check if the number is already present in the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) return false;
        }

        // Check if the number is already present in the column
        for (int[] nums : board) {
            if (nums[col] == num) return false;
        }

        // Check the 3x3 subgrid the cell belongs to
        int sqrt = (int) Math.sqrt(board.length);  // Size of the subgrid
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        // Check each cell in the subgrid
        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) return false;
            }
        }
        return true;  // It's safe to place the number
    }
}
