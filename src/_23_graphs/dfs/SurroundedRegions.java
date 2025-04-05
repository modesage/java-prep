package _23_graphs.dfs;
//https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {
    // DFS helper function
    void dfs(int row, int col, int[][] vis, char[][] board, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        int m = board.length;       // number of rows
        int n = board[0].length;    // number of columns

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                    && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, board, delRow, delCol);
            }
        }
    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        int m = board.length;       // number of rows
        int n = board[0].length;    // number of columns
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int[][] vis = new int[m][n];

        // Traverse first and last row
        for (int j = 0; j < n; j++) {
            // First row
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delRow, delCol);
            }
            // Last row
            if (vis[m-1][j] == 0 && board[m-1][j] == 'O') {
                dfs(m-1, j, vis, board, delRow, delCol);
            }
        }

        // Traverse first and last column
        for (int i = 0; i < m; i++) {
            // First column
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delRow, delCol);
            }
            // Last column
            if (vis[i][n-1] == 0 && board[i][n-1] == 'O') {
                dfs(i, n-1, vis, board, delRow, delCol);
            }
        }

        // Replace all unvisited 'O' cells with 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
