package _12_bitwise;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 32; // Change this value to test different numbers

        // Call the function and print the result
        System.out.println(isPowerOfTwo(n));
    }

    /**
     * Checks if a given integer is a power of two.
     *
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public static boolean isPowerOfTwo(int n) {
        // A number is a power of two if it is greater than zero and has only one bit set in its binary representation.
        return n > 0 && (n & (n - 1)) == 0;
    }
}
