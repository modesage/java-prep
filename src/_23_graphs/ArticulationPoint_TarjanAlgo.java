package _23_graphs;

import java.util.*;

// Articulation Points are the vertices whose removal increases the number of connected components in the graph.
// In other words, they are "critical nodes" for the connectivity of the graph.
public class ArticulationPoint_TarjanAlgo {
    private int timer = 1;

    // Helper DFS function to find articulation points
    private void dfs(int node, int parent, int[] vis, int[] tin, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;  // Set discovery and low time
        int children = 0; // Count of children in DFS Tree

        for (Integer neighbor : adj.get(node)) {
            if (neighbor == parent) continue; // Ignore the edge to parent

            if (vis[neighbor] == 0) {
                // If neighbor is not visited, recurse
                dfs(neighbor, node, vis, tin, low, mark, adj);

                // Update low time
                low[node] = Math.min(low[node], low[neighbor]);

                // Articulation point condition (for non-root nodes)
                if (low[neighbor] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                children++;
            } else {
                // If neighbor is already visited, update low time (Back Edge)
                low[node] = Math.min(low[node], tin[neighbor]);
            }
        }

        // Special case for root node: if it has more than one child
        if (parent == -1 && children > 1) {
            mark[node] = 1;
        }
    }

    // Main function to find all articulation points
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n]; // mark[i] = 1 if i is an articulation point

        // Perform DFS for each unvisited node (in case the graph is disconnected)
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }

        // If no articulation point is found, return -1
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }
}
