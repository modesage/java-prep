package _23_graphs.mst_disjoint_set;
//https://leetcode.com/problems/swim-in-rising-water/description/
import java.util.*;
public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int totalCells = n * n;

        DisjointSet ds = new DisjointSet(totalCells);

        // Store all cells with their elevations
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new int[]{grid[i][j], i, j});
            }
        }

        // Sort cells by elevation
        cells.sort((a, b) -> a[0] - b[0]);

        boolean[][] visited = new boolean[n][n];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int[] cell : cells) {
            int elevation = cell[0];
            int x = cell[1];
            int y = cell[2];

            visited[x][y] = true;

            // Union with visited neighbors
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny]) {
                    int node1 = x * n + y;
                    int node2 = nx * n + ny;
                    ds.unionBySize(node1, node2);
                }
            }

            // Check if start (0,0) and end (n-1,n-1) are connected
            if (ds.findUltParent(0) == ds.findUltParent(totalCells - 1)) {
                return elevation;
            }
        }

        return -1; // Should not reach here
    }
}
