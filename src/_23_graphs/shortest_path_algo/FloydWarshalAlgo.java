package _23_graphs.shortest_path_algo;

/**
 * Implementation of the Floyd-Warshall algorithm.
 * This algorithm computes the shortest distances between every pair of vertices in a weighted graph.
 * It also detects the presence of a negative weight cycle.
 */
public class FloydWarshalAlgo {
    /**
     * Computes the shortest distance between all pairs of nodes in the given adjacency matrix.
     * The matrix should represent the graph where:
     *   - matrix[i][j] is the weight of the edge from vertex i to vertex j.
     *   - A value of -1 indicates that there is no direct edge between i and j.
     *
     * The algorithm replaces -1 with a large number to simulate "infinity" for missing edges.
     * After processing, any distance that remains "infinity" is converted back to -1 for clarity.
     *
     * It also detects a negative cycle by checking if the distance from a node to itself becomes negative.
     *
     * @param matrix An adjacency matrix representing the graph.
     * @return true if a negative weight cycle is detected, false otherwise.
     */
    boolean shortest_distance(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Pre-process the matrix:
        //   - Replace -1 with a large number (to simulate infinity) for non-existent edges.
        //   - Set the distance from each vertex to itself as 0.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9; // Using 1e9 as a substitute for "infinity"
                }
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 2: Run the Floyd-Warshall algorithm.
        // For each possible intermediate vertex 'k', update the shortest paths.
        // The idea is to see if going through vertex k improves the current known shortest path.
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Update the distance from i to j to the minimum of the current value
                    // and the distance going through vertex k.
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // Step 3: Check for the presence of negative weight cycles.
        // A negative cycle exists if the distance from any vertex to itself becomes negative.
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] < 0) {
                System.out.println("Negative cycle detected.");
                return true;
            }
        }

        // Step 4: Post-process the matrix:
        // Convert any "infinity" values back to -1 to indicate that there is no path between those vertices.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }

        return false;
    }
}
