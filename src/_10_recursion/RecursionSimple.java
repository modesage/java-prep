package _10_recursion;

public class RecursionSimple {
    public static void main(String[] args) {
        print(1);
    }
    static void print(int n){
        //base condition
        //if there will be no base condition to terminate the recursive calling then a time will come that the stack memory will become full
        //leading to stack overflow error
        if(n == 5){
            System.out.println(5);
            return;
        }
        System.out.println(n);
        //recursive call
        //when calling a function again and again without the previous function to end, then it will be a separate call in the stack memory
        print(n+1);
    }
}
