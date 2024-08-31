package _06_searching.binary;
//leetcode
//1095. Find in Mountain Array

// Define the MountainArray interface
interface BitonicArray {
    public int get(int index);
    public int length();
}

// Mock implementation of MountainArray using a regular array
class MockBitonicArray implements BitonicArray {
    private int[] arr;

    public MockBitonicArray(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }
}

// Solution class that uses the MountainArray interface
class Solution {
    public int findInMountainArray(int target, BitonicArray mountainArr) {
        int n = mountainArr.length();

        // Find the peak of the mountain array
        int peak = findPeak(mountainArr, n);

        // Perform binary search in the ascending part of the array
        int result = binarySearch(mountainArr, target, 0, peak, true);
        if (result != -1) {
            return result;
        }

        // Perform binary search in the descending part of the array
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    // Find the peak index in the mountain array
    private int findPeak(BitonicArray mountainArr, int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Binary search algorithm that works for both ascending and descending arrays
    private int binarySearch(BitonicArray mountainArr, int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);

            if (target == midVal) {
                return mid;
            }

            if (ascending) {
                if (target < midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

// Main class to test the Solution
public class FindInMountainArray {
    public static void main(String[] args) {
        int[] mountainArr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;

        // Create a mock MountainArray
        BitonicArray mockBitonicArray = new MockBitonicArray(mountainArr);

        // Create a Solution object and test it
        Solution solution = new Solution();
        int result = solution.findInMountainArray(target, mockBitonicArray);

        System.out.println(result);
    }
}

