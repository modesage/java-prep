package _10_recursion._2_basic;

public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }
    static int sum(int n){
        if(n <= 0){
            System.out.println("the destination integer should be greater than 0");
            return -1;
        }
        if(n == 1){
            return 1;
        }
        return sum(n-1) + n;
    }
}
