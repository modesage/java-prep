package _06_searching.binary;
//asked in Google
// LeetCode: 410. Split Array Largest Sum
public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    /**
     * Finds the minimum largest sum of subarrays after splitting the array into k subarrays.
     *
     * @param nums The array of integers to split.
     * @param k The number of subarrays to split into.
     * @return The minimized largest sum of subarrays.
     */
    public static int splitArray(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input.");
        }

        int start = 0; // Maximum value in nums
        int end = 0;   // Sum of all elements in nums

        for (int num : nums) {
            start = Math.max(start, num); // The largest single element
            end += num; // Total sum of all elements
        }

        // Binary search to find the minimal largest sum
        while (start < end) {
            int mid = start + (end - start) / 2;

            // Check if it's possible to split into k or more subarrays with sum <= mid
            int sum = 0;
            int pieces = 1; // Start with one subarray

            for (int num : nums) {
                if (sum + num > mid) {
                    sum = num; // Start a new subarray
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > k) {
                start = mid + 1; // Need a larger maximum sum
            } else {
                end = mid; // Try a smaller maximum sum
            }
        }

        return end; // Here, start == end, which is the minimized largest sum
    }
}
