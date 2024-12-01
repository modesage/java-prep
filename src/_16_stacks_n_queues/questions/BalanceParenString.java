package _16_stacks_n_queues.questions;
//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
public class BalanceParenString {

    public static void main(String[] args) {
        String s = "(()))";
        System.out.println(minInsertions(s));
    }

    public static int minInsertions(String s) {
        int ans = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // we have '))'
                    if (open == 0) {
                        // no matching '('
                        ans++;
                    } else {
                        open--;
                    }
                    i++; // skip the next ')'
                } else {
                    // we have single ')'
                    if (open == 0) {
                        // no matching '('
                        ans += 2; // add '(' and ')'
                    } else {
                        open--;
                        ans++; // add ')'
                    }
                }
            }
        }

        // add '))' for remaining '('
        ans += open * 2;

        return ans;
    }
}
