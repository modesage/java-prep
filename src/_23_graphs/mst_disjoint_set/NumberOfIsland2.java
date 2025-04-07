package _23_graphs.mst_disjoint_set;
import java.util.*;

// https://leetcode.com/problems/number-of-islands-ii/description/
// This class handles online queries for counting islands as new lands are added.
public class NumberOfIsland2 {

    // Helper method to check if the given row and column indices are within the grid boundaries.
    private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    // Method to process a list of operators (each representing adding a land at a position)
    // and returns a list of island counts after each operator.
    List<Integer> numOfIslands(int n, int m, int[][] operators) {
        // Initialize Disjoint Set for all possible grid cells (flattened index: row * m + col).
        DisjointSet ds = new DisjointSet(n * m);

        // 2D array to track visited (or land) cells. 0 means water, 1 means land.
        int[][] vis = new int[n][m];

        // Counter for the current number of islands.
        int cnt = 0;

        // List to store the answer after processing each operator.
        List<Integer> ans = new ArrayList<>();

        // Process each operator (each operator represents a new land addition).
        int len = operators.length;
        for (int i = 0; i < len; i++) {
            int row = operators[i][0];
            int col = operators[i][1];

            // If the cell is already land, add the current island count and move to the next operator.
            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }

            // Mark the cell as land and increase the island count.
            vis[row][col] = 1;
            cnt++;

            // Arrays to help explore the four adjacent directions (up, right, down, left).
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};

            // Check all four neighbors of the current cell.
            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];

                // If the neighboring cell is within grid boundaries.
                if (isValid(adjr, adjc, n, m)) {
                    // If the neighbor is already land.
                    if (vis[adjr][adjc] == 1) {
                        // Compute flattened index for current cell and the neighbor.
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjr * m + adjc;

                        // If the current cell and the neighbor belong to different islands (different parents)
                        if (ds.findUltParent(nodeNo) != ds.findUltParent(adjNodeNo)) {
                            // They are separate islands, so union them, which reduces the total island count.
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }

            // After processing the current operator, add the current island count to the answer list.
            ans.add(cnt);
        }
        // Return the list of island counts after each operator.
        return ans;
    }
}
