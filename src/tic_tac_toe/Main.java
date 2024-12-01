package tic_tac_toe;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player " + player + ", enter row and column (1-3): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input. Please enter values between 1 and 3 for row and column.");
                continue;  // Skip current iteration if invalid input
            }

            if (board[row][col] == ' ') {
                board[row][col] = player; // Place the element
                if (haveWon(board, player)) {
                    printBoard(board);
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                } else {
                    // Check for draw
                    int filledCells = 0;
                    for (int r = 0; r < board.length; r++) {
                        for (int c = 0; c < board[r].length; c++) {
                            if (board[r][c] != ' ') filledCells++;
                        }
                    }
                    if (filledCells == 9) {
                        printBoard(board);
                        System.out.println("It's a draw!");
                        gameOver = true;
                    }
                    player = (player == 'X') ? 'O' : 'X'; // Switch player
                }
            } else {
                System.out.println("This cell is already occupied! Try again.");
            }
        }

        scanner.close();
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check the columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if (col < 2) System.out.print(" | ");
            }
            System.out.println();
            if (row < 2) System.out.println("---------"); // Line between rows
        }
    }
}
