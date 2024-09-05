package _12_bitwise;
//set the ith bit to 1
public class SetBit {
    public static void main(String[] args) {
        int num = 0b0110; // Binary representation of 6
        int position = 4; // Position to set to 1 (1-based index)
        int result = setBit(num, position);
        System.out.println("Result: " + Integer.toBinaryString(result));
    }

    static int setBit(int num, int position) {
        // Create a mask with 1 at the desired position (0-based index)
        int mask = 1 << (position - 1);
        // Use bitwise OR to set the bit at the position to 1
        return num | mask;
    }
}
