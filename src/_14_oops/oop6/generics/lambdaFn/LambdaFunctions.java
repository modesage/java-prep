package _14_oops.oop6.generics.lambdaFn;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            arr.add(i+1);
//        }
        //(item) -> System.out.println(item * 2) this is a lambda function

//        arr.forEach((item) -> System.out.println(item * 2));

        //or we can give a Consumer type as forEach() can have it
        //lambda functions can be assigned to variables that are of type interfaces
//        Consumer<Integer> fun = (item) -> System.out.println(item * 2);
//        arr.forEach(fun);

        Operation sum = (a,b) -> a + b;
        Operation sub = (a,b) -> a - b;
        Operation prod = (a,b) -> a * b;

        LambdaFunctions myCalc = new LambdaFunctions();
        int result = myCalc.operate(5,4,prod);
        System.out.println(result);
    }
    private int operate(int a, int b, Operation op){
        return op.operation(a,b);
    }
}

interface Operation{
    //abstract method
    int operation(int a, int b);
}