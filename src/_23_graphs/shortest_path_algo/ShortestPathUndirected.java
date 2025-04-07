package _23_graphs.shortest_path_algo;
//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
import java.util.*;

public class ShortestPathUndirected {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int vertices = adj.size();
        int[] dist = new int[vertices];
        Arrays.fill(dist, (int) 1e9); // Simulate infinity
        dist[src] = 0;

        // Using ArrayDeque for efficient queue operations
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        // Standard BFS traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                // Since the graph is undirected and edges have unit weight
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        // Replace nodes unreachable from src with -1
        for (int i = 0; i < vertices; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
