package _16_stacks_n_queues.questions;

// Hackerrank problem: Game of Two Stacks
// https://www.hackerrank.com/challenges/game-of-two-stacks/problem

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {

    /*
     * Complete the 'twoStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER maxSum
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

    /*
input
1
5 4 10
4 2 4 6 1
2 1 8 5

output
4
    */

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        int localSum = 0;   // Keeps track of the current sum of selected elements
        int count = 0;      // Tracks the count of elements removed from the stacks
        int i = 0, j = 0;   // Two pointers for stacks 'a' and 'b'

        // First, try removing elements from stack 'a' as long as the sum does not exceed maxSum
        while (i < a.size() && localSum + a.get(i) <= maxSum) {
            localSum += a.get(i);
            count++;
            i++;  // Move to the next element in stack 'a'
        }

        // Now try removing elements from stack 'b' while ensuring the sum does not exceed maxSum
        int maxCount = count;  // Track the maximum number of elements removed
        while (j < b.size()) {
            localSum += b.get(j);  // Add element from stack 'b'
            j++;

            // If the sum exceeds maxSum, backtrack by removing elements from stack 'a'
            while (localSum > maxSum && i > 0) {
                i--;  // Move back in stack 'a'
                localSum -= a.get(i);  // Subtract the element from the sum
            }

            // If the sum is valid (<= maxSum), update the maximum count
            if (localSum <= maxSum) {
                maxCount = Math.max(maxCount, i + j);  // Total removed = i from 'a' + j from 'b'
            }
        }

        return maxCount;  // Return the maximum number of elements removed
    }

}

public class GameOfTwoStacks {
    public static void main(String[] args) throws IOException {
        // Initialize the input reader (Scanner or BufferedReader)
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int t = sc.nextInt();

        // Process each test case
        for (int i = 0; i < t; i++) {
            // Read the size of stacks a and b, and the max sum
            int n = sc.nextInt();
            int m = sc.nextInt();
            int maxSum = sc.nextInt();

            // Read the elements for stack a
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                a.add(sc.nextInt());
            }

            // Read the elements for stack b
            List<Integer> b = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                b.add(sc.nextInt());
            }

            // Call the function to compute the maximum number of elements we can remove
            int result = Result.twoStacks(maxSum, a, b);

            // Output the result for this test case
            System.out.println(result);
        }

        // Close the scanner
        sc.close();
    }
}

