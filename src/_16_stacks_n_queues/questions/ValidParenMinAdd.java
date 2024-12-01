package _16_stacks_n_queues.questions;
import java.util.Stack;

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
//facebook
public class ValidParenMinAdd {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
                count++;
            }
            else{
                if(stack.isEmpty()){
                    count++;
                }
                if(!stack.isEmpty()){
                    stack.pop();
                    count--;
                }
            }
        }
        return count;
    }
}