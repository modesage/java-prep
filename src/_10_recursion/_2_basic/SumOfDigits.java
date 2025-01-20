package _10_recursion._2_basic;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumDigits(102));
    }
    static int sumDigits(int n){
        if(n < 0){
            System.out.println("sum is only for positive integer digits");
            return -1;
        }
        if(n % 10 == n){
            return n;
        }
        return (n % 10) + sumDigits(n / 10);
    }
}
