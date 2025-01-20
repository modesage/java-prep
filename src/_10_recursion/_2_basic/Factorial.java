package _10_recursion._2_basic;

public class Factorial {
    public static void main(String[] args) {
        int result = fact(4);
        System.out.println(result);
    }
    static int fact(int n){
        if(n < 0) {
            System.out.println("The factorial is not defined for negative numbers");
            return -1;
        }
        if(n == 1 || n == 0){
            return 1;
        }
        return fact(n-1) * n;
    }
}
