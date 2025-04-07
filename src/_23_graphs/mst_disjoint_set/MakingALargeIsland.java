package _23_graphs.mst_disjoint_set;
import java.util.*;
//https://leetcode.com/problems/making-a-large-island/description/
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        // Initialize DisjointSet for all cells in the grid.
        // Each cell is uniquely mapped to an index: index = i * n + j.
        DisjointSet ds = new DisjointSet(n * n);

        // Directions for 4-connected neighbors: up, right, down, left.
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // First pass: Union all adjacent cells that have value 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {  // Process only land cells.
                    int cellIndex = i * n + j;
                    // Check all 4 neighbors.
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + dr[k];
                        int newCol = j + dc[k];
                        // Check if neighbor is within bounds and is also land.
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                            int neighborIndex = newRow * n + newCol;
                            ds.unionBySize(cellIndex, neighborIndex);
                        }
                    }
                }
            }
        }

        // Variable to track the maximum island area found.
        int maxArea = 0;
        // Also check the largest island without any change.
        for (int i = 0; i < n * n; i++) {
            // Only consider root parents and land cells.
            if (ds.parent[i] == i) {
                maxArea = Math.max(maxArea, ds.size[i]);
            }
        }

        // Second pass: For each water cell (0), try flipping it to land and calculate
        // the potential island area by summing up unique neighboring islands.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { // Only process water cells.
                    // Use a set to ensure each neighboring island is counted only once.
                    Set<Integer> uniqueIslands = new HashSet<>();
                    // Explore all 4 directions.
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + dr[k];
                        int newCol = j + dc[k];
                        // Check bounds.
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                            int islandParent = ds.findUltParent(newRow * n + newCol);
                            uniqueIslands.add(islandParent);
                        }
                    }
                    // Calculate total area if current water cell is flipped to land.
                    int areaWithFlip = 1; // current cell flipped to land.
                    for (int parent : uniqueIslands) {
                        areaWithFlip += ds.size[parent];
                    }
                    maxArea = Math.max(maxArea, areaWithFlip);
                }
            }
        }

        // If no water cell was flipped, maxArea holds the size of the largest island.
        // Also, if grid is entirely 1's, maxArea would be n*n.
        return maxArea;
    }
}
