package _23_graphs;

import java.util.ArrayList;
import java.util.Stack;

// This class implements Kosaraju's algorithm to find the number of strongly connected components (SCCs)
// in a directed graph. The algorithm works in three main steps:
// 1. Perform a DFS to compute the finishing order of vertices (stored in a stack).
// 2. Reverse the graph (invert the direction of all edges).
// 3. Perform DFS on the reversed graph in the order defined by the stack to identify SCCs.
public class SCC_KosarajuAlgo {

    // Helper DFS method for the first pass.
    // It visits nodes in the original graph and pushes nodes onto the stack based on their finishing times.
    // Parameters:
    // - node: current node being visited.
    // - vis: an array to mark visited nodes.
    // - adj: the adjacency list representing the original graph.
    // - st: a stack to store nodes based on finishing times.
    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        // Mark the current node as visited.
        vis[node] = 1;
        // Traverse all adjacent nodes (neighbors) of the current node.
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) { // If the neighbor hasn't been visited, recursively perform DFS.
                dfs(it, vis, adj, st);
            }
        }
        // After visiting all neighbors, push the current node onto the stack.
        st.push(node);
    }

    // Helper DFS method for the second pass on the reversed graph.
    // It visits all nodes in a component starting from the given node.
    // Parameters:
    // - node: current node being visited in the reversed graph.
    // - vis: an array to mark visited nodes.
    // - adjT: the adjacency list representing the reversed graph.
    private void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        // Mark the current node as visited.
        vis[node] = 1;
        // Traverse all adjacent nodes (neighbors) in the reversed graph.
        for (Integer it : adjT.get(node)) {
            if (vis[it] == 0) { // If the neighbor hasn't been visited, recursively perform DFS.
                dfs3(it, vis, adjT);
            }
        }
    }

    // Main method to perform Kosaraju's algorithm.
    // Parameters:
    // - V: number of vertices in the graph.
    // - adj: adjacency list of the original graph.
    // Returns the number of strongly connected components (SCCs) found in the graph.
    int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create an array to track visited nodes (0 means unvisited, 1 means visited).
        int[] vis = new int[V];
        // Stack to store nodes based on their finishing times during DFS.
        Stack<Integer> st = new Stack<>();

        // Step 1: Perform DFS on the original graph to fill the stack with vertices.
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // Step 2: Create the reversed graph (transpose of the original graph).
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            // Initialize the list for each vertex in the reversed graph.
            adjT.add(new ArrayList<>());
        }
        // Reset the visited array for the second DFS.
        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            // Reverse the graph: for each edge from i to 'it', add an edge from 'it' to i.
            for (Integer it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        // Step 3: Process nodes in the order defined by the stack to identify SCCs.
        int scc = 0; // Counter for the number of strongly connected components.
        while (!st.isEmpty()) {
            // Pop a node from the stack.
            int node = st.peek();
            st.pop();
            // If the node hasn't been visited in the reversed graph, it's the start of a new SCC.
            if (vis[node] == 0) {
                scc++; // Increment the SCC counter.
                dfs3(node, vis, adjT); // Visit all nodes in this SCC.
            }
        }
        // Return the total number of strongly connected components.
        return scc;
    }
}
