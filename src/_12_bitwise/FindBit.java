package _12_bitwise;
//finding the ith bit
public class FindBit {
    public static void main(String[] args) {
        int num = 0b01110010;
        int position = 5;
        int result = bit(num, position);
        System.out.println(result);
    }
    static int bit(int num, int position){
        return num >> (position - 1) & 1;
    }

}
