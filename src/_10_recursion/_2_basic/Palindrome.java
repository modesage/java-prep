package _10_recursion._2_basic;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(12321));
    }
    static int revNum(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }
    private static int helper(int n, int digits) {
        if(n % 10 == n){
            return n;
        }
        return (n % 10) * (int)(Math.pow(10,digits-1)) + helper(n / 10, digits - 1);
    }
    static boolean palindrome(int n){
        return n == revNum(n);
    }
}
