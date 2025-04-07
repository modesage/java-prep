package _23_graphs.shortest_path_algo;
//https://leetcode.com/problems/network-delay-time/description/
import java.util.*;
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the graph as an adjacency list.
        // graph[u] holds pairs [v, w] representing an edge from u to v with weight w.
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
        }

        // Use a min-heap (priority queue) for Dijkstra's algorithm.
        // Each element is a pair: [node, currentDistance]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // Distance array to store the minimum distance from node k to each node.
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // Starting node k has a distance of 0.
        dist[k] = 0;
        pq.offer(new int[]{k, 0});

        // Process nodes in increasing order of their current distance.
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], d = current[1];
            // If this distance is not up-to-date, skip it.
            if (d > dist[node]) continue;
            // Check all neighbors of the current node.
            for (int[] neighbor : graph[node]) {
                int v = neighbor[0], w = neighbor[1];
                // If a shorter path to neighbor is found, update the distance and add to the queue.
                if (dist[node] + w < dist[v]) {
                    dist[v] = dist[node] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // Find the maximum distance from node k to any node.
        // If any node is unreachable (distance remains Integer.MAX_VALUE), return -1.
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }
}
