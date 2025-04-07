package _23_graphs.mst_disjoint_set;
// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class ConnectNetwork {
    // n: total number of nodes (computers)
    // connections: 2D array representing direct connections between nodes
    public int makeConnected(int n, int[][] connections) {
        // Initialize a DisjointSet (Union-Find structure) for n nodes
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0; // Counter to keep track of redundant (extra) connections
        for (int[] connection : connections) {
            int u = connection[0]; // First computer in the connection
            int v = connection[1]; // Second computer in the connection
            // Check if u and v are already connected
            if (ds.findUltParent(u) == ds.findUltParent(v)) {
                cntExtras++; // If already connected, this is an extra cable
            } else {
                ds.unionBySize(u, v); // If not connected, merge the two sets (connect the computers)
            }
        }
        int cntC = 0; // Count the number of connected components
        for (int i = 0; i < n; i++) {
            // A node is the representative of a component if it is its own parent
            if (ds.parent[i] == i) {
                cntC++;
            }
        }
        int ans = cntC - 1; // The minimum operations required is the number of components minus one
        // If there are enough extra cables to connect all components, return the required operations.
        // Otherwise, return -1 indicating it's not possible to connect the network.
        if (cntExtras >= ans) return ans;
        return -1;
    }
}
