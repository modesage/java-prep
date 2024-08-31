package _06_searching.binary;

// LeetCode 33. Search in Rotated Sorted Array
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {6,7,8,9,0,1,2,3,4,5};
        int target = 4;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Determine which part of the array is sorted
            if (nums[start] <= nums[mid]) {
                // Left part is sorted
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // Right part is sorted
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
