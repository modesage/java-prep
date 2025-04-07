package _23_graphs.mst_disjoint_set;
//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
public class RemoveStones {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        // Initialize DisjointSet for n stones (each stone is treated as a node)
        DisjointSet ds = new DisjointSet(n);

        // Union stones that share the same row or column
        // Loop through each pair of stones
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // If stones share the same row or same column, union their indices.
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    ds.unionBySize(i, j);
                }
            }
        }

        // Count the number of connected components.
        // A stone is a representative (or parent) if ds.parent[i] == i.
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUltParent(i) == i) {
                components++;
            }
        }

        // Maximum stones removed = total stones - number of connected components.
        // In each connected component, we must leave one stone.
        return n - components;
    }
}
