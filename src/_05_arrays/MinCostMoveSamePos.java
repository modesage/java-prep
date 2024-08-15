package _05_arrays;
//leetcode
//1217. Minimum Cost to Move Chips to The Same Position
public class MinCostMoveSamePos {
    public static void main(String[] args) {
        int[] position = {1,2,3};
        int result = minCostToMoveChips(position);
        System.out.println(result);
    }
    public static int minCostToMoveChips(int[] position) {
        int oddCount = 0;
        int evenCount = 0;

        // Count the number of chips on odd and even positions
        for (int pos : position) {
            if (pos % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // The minimum cost is the smaller of the two counts
        return Math.min(oddCount, evenCount);
    }
}
