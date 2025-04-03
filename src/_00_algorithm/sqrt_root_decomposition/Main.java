package _00_algorithm.sqrt_root_decomposition;
// This algorithm is also called as Mo's Algorithm, often used for answering range queries efficiently.

class Main {
    public static void main(String[] args) {
        // Input array
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;  // Get the length of the array

        // Calculate the block size using the square root decomposition technique
        int sqrt = (int) Math.sqrt(n);

        int block_id = -1;  // Initialize block_id (it will help in identifying the block)

        // Array to store the block sums
        int[] blocks = new int[sqrt + 1]; // We need sqrt + 1 blocks to cover the entire array

        // Populate the blocks array by calculating the sum of elements in each block
        for(int i = 0; i < n; i++) {
            // Start a new block whenever we hit a multiple of sqrt
            if(i % sqrt == 0) {
                block_id++;  // Increment block_id when a new block starts
            }
            blocks[block_id] += arr[i];  // Add the element to the current block's sum
        }

        // Query to find the sum of elements in the range [2, 7]
        // The block array `blocks` helps to calculate sums in a very efficient manner
        System.out.println(query(blocks, arr, 2, 7, sqrt));
    }

    // Query function to get the sum of elements in the range [l, r]
    // Uses square root decomposition technique
    public static int query(int[] blocks, int[] arr, int l, int r, int sqrt) {
        int ans = 0;  // Variable to store the result of the query

        // Handle the left part of the range (before the first block)
        while(l % sqrt != 0 && l < r && l != 0) {
            ans += arr[l];  // Add the element to the answer
            l++;  // Move to the next element
        }

        // Handle the middle part of the range (within the complete blocks)
        while(l + sqrt <= r) {
            ans += blocks[l / sqrt];  // Add the precomputed block sum
            l += sqrt;  // Skip to the next block
        }

        // Handle the right part of the range (after the last complete block)
        while(l <= r) {
            ans += arr[l];  // Add the element to the answer
            l++;  // Move to the next element
        }

        return ans;  // Return the final computed sum
    }

    // Update function to update the value of an element in the array and adjust the blocks array
    public void update(int[] blocks, int[] arr, int i, int val, int sqrt) {
        int block_id = i / sqrt;  // Find the block that contains the element at index i

        // Update the block sum by adjusting it with the difference between the new value and the old value
        blocks[block_id] += (val - arr[i]);
        arr[i] = val;  // Update the element in the original array
    }
}
