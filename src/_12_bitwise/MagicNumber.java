package _12_bitwise;
//Amazon
public class MagicNumber {
    public static void main(String[] args) {
        int n = 3;
        int ans = 0;

        int base = 5;
        while(n > 0){
            int last = n & 1;
            ans += last * base;
            n = n >> 1;
            base = base * 5;
        }

        System.out.println("Magic Number: " + ans);
    }
}
