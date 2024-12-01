package _10_recursion._2_basic;

public class ReverseNum {
    public static void main(String[] args) {
//        revNum1(1824);
//        System.out.println(newNum);
        System.out.println(revNum2(1234));
    }

    static int newNum = 0;
    static void revNum1(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        newNum = (newNum * 10) + rem;
        revNum1(n / 10);
    }

    static int revNum2(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }
    private static int helper(int n, int digits) {
        if(n % 10 == n){
            return n;
        }
        return (n % 10) * (int)(Math.pow(10,digits-1)) + helper(n / 10, digits - 1);
    }
}
