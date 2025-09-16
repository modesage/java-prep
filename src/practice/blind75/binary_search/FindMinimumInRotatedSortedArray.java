package practice.blind75.binary_search;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be to the right of mid
                left = mid + 1;
            } else {
                // Minimum is at mid or to the left of mid
                right = mid;
            }
        }

        return nums[left]; // or nums[right], both are equal here
    }
}
