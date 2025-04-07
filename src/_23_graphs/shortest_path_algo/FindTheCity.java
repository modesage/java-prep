package _23_graphs.shortest_path_algo;
//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
import java.util.*;
public class FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Use a large number to represent "infinity"
        int INF = (int) 1e9;

        // Initialize the distance matrix with "infinity" for no direct edge,
        // and 0 for the same city (diagonal elements)
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            // Initially fill all distances with INF
            for (int j = 0; j < n; j++) {
                dist[i][j] = INF;
            }
            // Distance from a city to itself is always 0
            dist[i][i] = 0;
        }

        // Set the direct edge distances from the given edges array.
        // Since the graph is bidirectional, update both [u][v] and [v][u]
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // Run the Floyd-Warshall algorithm to compute shortest paths between every pair of cities.
        // For each possible intermediate city 'k'
        for (int k = 0; k < n; k++) {
            // For each starting city 'i'
            for (int i = 0; i < n; i++) {
                // For each destination city 'j'
                for (int j = 0; j < n; j++) {
                    // If the path through k is shorter, update the distance
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Determine the city with the smallest number of reachable neighbors within the threshold.
        int resultCity = -1;
        int minReachableCount = Integer.MAX_VALUE;
        // Iterate over every city
        for (int i = 0; i < n; i++) {
            int count = 0;
            // Count how many cities are reachable within the given distanceThreshold
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            // Update the result:
            // Choose the city with the smaller count; if equal, choose the city with the greater index.
            if (count < minReachableCount || (count == minReachableCount && i > resultCity)) {
                minReachableCount = count;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
