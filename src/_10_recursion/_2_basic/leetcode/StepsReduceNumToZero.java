package _10_recursion._2_basic.leetcode;
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
public class StepsReduceNumToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(123));
    }
    static int numberOfSteps(int num) {
        //created helper function as we need to pass the arguments to every function call
        return helper(num,0);
    }
    static int helper(int num, int steps){
        //when num becomes zero
        //the number of steps is passed above to every function in return flow
        if(num == 0){
            return steps;
        }
        if(num % 2 == 0){
            return helper(num / 2, ++steps);
        }
        return helper(num - 1, ++steps);
    }
}
