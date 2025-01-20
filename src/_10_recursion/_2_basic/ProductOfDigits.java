package _10_recursion._2_basic;

public class ProductOfDigits {
    public static void main(String[] args) {
        System.out.println(productDigits(55));
    }
    static int productDigits(int n){
        if(n < 0){
            System.out.println("product is only for positive integer digits");
            return -1;
        }
        if(n % 10 == n){
            return n;
        }
        return (n % 10) * productDigits(n / 10);
    }
}
