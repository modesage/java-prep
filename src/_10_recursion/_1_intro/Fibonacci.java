package _10_recursion._1_intro;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 20;
        int result = fibo(num);
        System.out.println(result);
    }
    static int fibo(int num){
        if (num < 0) {
            return -1; // Error case: Fibonacci numbers are not defined for negative indices
        }
        if (num == 0) {
            return 0; // Base case: F(0) = 0
        }
        if (num == 1) {
            return 1; // Base case: F(1) = 1
        }
        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fibo(num - 1) + fibo(num - 2);
    }
}
