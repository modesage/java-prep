package _23_graphs;

// Finding bridges in a graph using Tarjan's Algorithm
// https://leetcode.com/problems/critical-connections-in-a-network/

import java.util.*;

public class BridgeInGraph_TarjanAlgo {
    private int timer = 1; // Global timer to assign unique discovery times to each node

    // Depth-First Search function to find bridges
    private void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj,
                     int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1; // Mark the current node as visited
        tin[node] = low[node] = timer++; // Set discovery time and lowest reachable time

        // Visit all adjacent nodes
        for (Integer neighbor : adj.get(node)) {
            if (neighbor == parent) continue; // Ignore the edge to parent node

            if (vis[neighbor] == 0) { // If neighbor is unvisited
                dfs(neighbor, node, vis, adj, tin, low, bridges); // Recur on neighbor

                // After returning from recursion, update low time of current node
                low[node] = Math.min(low[node], low[neighbor]);

                // Bridge condition: if the lowest time reachable from neighbor is
                // greater than the discovery time of current node
                if (low[neighbor] > tin[node]) {
                    bridges.add(Arrays.asList(neighbor, node)); // Record the bridge
                }
            } else {
                // If neighbor is already visited and not the parent, it’s a back-edge
                low[node] = Math.min(low[node], low[neighbor]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Build adjacency list for the undirected graph
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];  // Visited array
        int[] tin = new int[n];  // Time of insertion (discovery time)
        int[] low = new int[n];  // Lowest discovery time reachable

        List<List<Integer>> bridges = new ArrayList<>(); // List to store all bridges

        // Start DFS from node 0 with parent -1 (no parent)
        dfs(0, -1, vis, adj, tin, low, bridges);

        return bridges; // Return the list of critical connections
    }
}
