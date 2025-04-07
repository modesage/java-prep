package _23_graphs.mst_disjoint_set;

import java.util.*;

/**
 * Implementation of Prim's Algorithm to compute the sum of edge weights in the Minimum Spanning Tree (MST)
 * for an undirected graph.
 */
public class PrimsAlgo {

    /**
     * A helper class representing an edge in the priority queue.
     * Each Pair object holds the target node, the weight of the edge, and the parent node from which the edge originates.
     */
    static class Pair {
        int node;
        int distance;
        int parent;

        Pair(int node, int distance, int parent) {
            this.node = node;
            this.distance = distance;
            this.parent = parent;
        }
    }

    /**
     * Computes the sum of the edge weights in the MST for the given graph.
     *
     * @param V   The number of vertices in the graph.
     * @param adj The graph represented as an adjacency list. Each vertex's list contains pairs [adjacentNode, weight].
     * @return The total weight (sum) of the MST.
     */
    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // PriorityQueue to always pick the edge with the smallest weight.
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        // Boolean array to mark whether a vertex is already included in the MST.
        boolean[] vis = new boolean[V];

        // Start from vertex 0 with an initial weight of 0 and no parent (-1).
        pq.add(new Pair(0, 0, -1));

        int sum = 0; // Total weight of the MST.

        // Process nodes until the priority queue is empty.
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.distance;

            // If the node is already visited, skip it.
            if (vis[node]) continue;

            // Mark the node as visited and add the current edge's weight to the MST sum.
            vis[node] = true;
            sum += wt;

            // For each adjacent node of the current node, add it to the priority queue if not visited.
            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edW = adj.get(node).get(i).get(1);
                if (!vis[adjNode]) {
                    pq.add(new Pair(adjNode, edW, node));
                }
            }
        }
        return sum;
    }
}
