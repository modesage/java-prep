package _12_bitwise;
//find the number of digits
public class NoOfDigits {
    public static void main(String[] args) {
        int num = 10;
        int base = 2;
        int ans = (int) (Math.log(num) / Math.log(base)) + 1;
        System.out.println(ans);
    }
}
