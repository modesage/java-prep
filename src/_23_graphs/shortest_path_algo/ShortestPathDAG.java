package _23_graphs.shortest_path_algo;
//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
import java.util.*;

public class ShortestPathDAG {
    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        // Loop through each Pair in the list of neighbors
        for (Pair p : adj.get(node)) {
            int v = p.first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Create the graph as an adjacency list where each node holds a list of Pair objects (neighbor, weight)
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Pair>());
        }
        // Populate the graph using the provided edges
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Perform topological sort using DFS
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        // Initialize distance array with a large value (simulate infinity)
        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0; // starting from node 0

        // Process nodes in topological order
        while (!st.isEmpty()) {
            int node = st.pop();
            // Only process if the node is reachable
            if (dist[node] != (int) 1e9) {
                for (Pair it : adj.get(node)) {
                    if (dist[node] + it.second < dist[it.first]) {
                        dist[it.first] = dist[node] + it.second;
                    }
                }
            }
        }

        // Replace unreachable distances with -1 for clarity
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9)
                dist[i] = -1;
        }

        return dist;
    }

    public static void main(String[] args) {
        // graph with 4 nodes and 2 directed weighted edges
        int N = 4;
        int M = 2;
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 1},
        };

        ShortestPathDAG sp = new ShortestPathDAG();
        int[] result = sp.shortestPath(N, M, edges);

        // Output the computed shortest distances from node 0
        System.out.println("Shortest distances from node 0: " + Arrays.toString(result));
    }
}

// storing a destination and a corresponding weight
class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
