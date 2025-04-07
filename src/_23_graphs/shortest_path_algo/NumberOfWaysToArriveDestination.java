package _23_graphs.shortest_path_algo;
//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
import java.util.*;
public class NumberOfWaysToArriveDestination {
    public int countPaths(int n, int[][] roads) {
        // Build the graph as an adjacency list.
        // Each node stores a list of (neighbor, travelTime) pairs.
        ArrayList<ArrayList<PairForHere>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            adj.get(u).add(new PairForHere(v, time));
            adj.get(v).add(new PairForHere(u, time)); // Roads are bi-directional.
        }

        // PriorityQueue to store (currentCost, currentNode) pairs.
        // We always process the node with the smallest cost first.
        PriorityQueue<PairForHere> pq = new PriorityQueue<>((a, b) -> Long.compare(a.first, b.first));
        pq.offer(new PairForHere(0, 0));  // Start from node 0 with 0 cost.

        // Use a long array for distances (to avoid overflow) and an int array for number of ways.
        long[] dist = new long[n];
        int[] ways = new int[n];
        long INF = (long) 1e15;  // A sufficiently large value.
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        int mod = (int) (1e9 + 7);

        // Modified Dijkstra's algorithm.
        while (!pq.isEmpty()) {
            PairForHere curr = pq.poll();
            long cost = curr.first;
            int node = curr.second;

            // If the current cost is greater than the best known cost, skip this entry.
            if (cost > dist[node]) continue;

            // Process all neighbors of the current node.
            for (PairForHere neighbor : adj.get(node)) {
                int nextNode = (int) neighbor.first;
                long newCost = cost + neighbor.second;

                // Case 1: Found a strictly shorter path to nextNode.
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    ways[nextNode] = ways[node];  // Inherit the number of ways.
                    pq.offer(new PairForHere(newCost, nextNode));
                }
                // Case 2: Found another shortest path with equal cost.
                else if (newCost == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % mod;
                }
            }
        }

        // Return the number of ways to reach destination (n - 1) modulo 1e9+7.
        return ways[n - 1] % mod;
    }
}
// Helper Pair class to store (cost, node) pairs.
// 'first' stores the cost (using long) and 'second' stores the node index.
class PairForHere {
    long first;
    int second;

    PairForHere(long first, int second) {
        this.first = first;
        this.second = second;
    }
}
