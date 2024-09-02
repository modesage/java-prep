package _00_algorithm;
//Amazon
//leetcode
//287. Find the Duplicate Number
public class FloydTortoiseHareAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        // Phase 1: Find intersection point in the cycle
        int tortoise = nums[0];
        int hare = nums[0];

        // Move tortoise by 1 step and hare by 2 steps
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Phase 2: Find the entrance to the cycle
        // Move hare to the start and find the duplicate number
        hare = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        // Return the duplicate number
        return hare;
    }
}
