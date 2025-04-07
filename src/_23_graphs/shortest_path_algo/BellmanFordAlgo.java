package _23_graphs.shortest_path_algo;

import java.util.*;

public class BellmanFordAlgo {
    // Returns an array of distances if no negative cycle exists,
    // or an array with a single element -1 if a negative cycle is detected.
    int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Initialize distances to a large number (simulate infinity)
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8); // Using 100,000,000 as "infinity"
        dist[S] = 0; // Distance to the source is 0

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            // Iterate over each edge in the graph
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                // Relaxation: if current distance to u is not infinity, and
                // we can improve distance to v by going through u, update it.
                if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Perform one more relaxation to check for negative weight cycles.
        // If we can still relax an edge, there is a negative cycle.
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                // Negative cycle detected. Return an array containing -1.
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        // No negative cycle detected; return the computed shortest distances.
        return dist;
    }
}
