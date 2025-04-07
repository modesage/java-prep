package _23_graphs.mst_disjoint_set;

/**
 * Disjoint Set (Union-Find) data structure
 * Optimizations: Path Compression + Union by Rank / Union by Size
 *
 * Time Complexity per operation: O(4 * alpha(n)) ≈ O(1) (almost constant)
 * Very useful for dynamic connectivity problems (e.g., Kruskal's MST).
 */
class DisjointSet {
    int[] rank;   // Used for union by rank (approximate tree height)
    int[] parent; // Parent array to track each node's parent
    int[] size;   // Used for union by size (number of nodes in the set)

    // Constructor: Initializes the disjoint set for 'n' elements (0 to n)
    public DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;   // Initially, each node is its own parent (self loop)
            size[i] = 1;     // Each set starts with size 1
            rank[i] = 0;     // Each node starts with rank 0
        }
    }

    /**
     * Finds the ultimate parent (root) of a node.
     * Applies Path Compression: Flattens the tree structure by directly connecting nodes to their root.
     */
    public int findUltParent(int node) {
        if (node == parent[node]) {
            return node;  // If a node is its own parent, it's the root
        }
        return parent[node] = findUltParent(parent[node]);  // Recursively find and flatten the path
    }

    /**
     * Union two sets using Union by Rank.
     * Attach the shorter tree under the taller tree to keep the overall tree shallow.
     *
     * @param u first node
     * @param v second node
     */
    public void unionByRank(int u, int v) {
        int ulp_u = findUltParent(u);  // Find root parent of u
        int ulp_v = findUltParent(v);  // Find root parent of v

        if (ulp_u == ulp_v) return;  // Already in the same set

        // Attach smaller rank tree under the bigger rank tree
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;  // u's root becomes child of v's root
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;  // v's root becomes child of u's root
        } else {
            // Both ranks are equal, so choose any one and increase its rank
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;  // Since the height increases after union
        }
    }

    /**
     * Union two sets using Union by Size.
     * Attach the smaller set under the larger set to keep the tree balanced.
     *
     * @param u first node
     * @param v second node
     */
    public void unionBySize(int u, int v) {
        int ulp_u = findUltParent(u);  // Find root parent of u
        int ulp_v = findUltParent(v);  // Find root parent of v

        if (ulp_u == ulp_v) return;  // Already in the same set

        // Attach the smaller set under the larger set
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;     // u's root becomes child of v's root
            size[ulp_v] += size[ulp_u]; // Update size of v's root set
        } else {
            parent[ulp_v] = ulp_u;     // v's root becomes child of u's root
            size[ulp_u] += size[ulp_v]; // Update size of u's root set
        }
    }
}

/**
 * Main class to test the Disjoint Set implementation.
 */
public class DisjointSetMain {
    public static void main(String[] args) {
        // Create a Disjoint Set for elements 0 to 7 (0-indexed, 8 elements total)
        DisjointSet ds = new DisjointSet(7);

        // Perform unions using union by size
        ds.unionBySize(1, 2); // Merge set containing 1 and set containing 2
        ds.unionBySize(2, 3); // Merge the resulting set with set containing 3
        ds.unionBySize(4, 5); // Merge set containing 4 and 5
        ds.unionBySize(6, 7); // Merge set containing 6 and 7
        ds.unionBySize(5, 6); // Merge the set {4,5} with {6,7}

        // Check if 3 and 7 are in the same set before union
        if (ds.findUltParent(3) == ds.findUltParent(7)) {
            System.out.println("Same"); // Should print "Not Same" initially
        } else {
            System.out.println("Not Same");
        }

        // Union the sets containing 3 and 7
        ds.unionBySize(3, 7);

        // Check again if 3 and 7 are in the same set after union
        if (ds.findUltParent(3) == ds.findUltParent(7)) {
            System.out.println("Same"); // Should print "Same" now
        } else {
            System.out.println("Not Same");
        }
    }
}
