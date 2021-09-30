package wsg.oj.java.leetcode.problems.p100;

import java.util.Deque;
import java.util.LinkedList;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 150. Evaluate Reverse Polish Notation (Medium)
 *
 * @author Kingen
 * @see Solution224
 * @see Solution282
 * @see <a href="https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/">Evaluate
 * Reverse Polish Notation</a>
 * @since 2021-07-12
 */
public class Solution150 implements Solution {

    /**
     * Uses a stack to store the operands and the results.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            char ch = token.charAt(token.length() - 1);
            if ('+' == ch) {
                stack.push(stack.pop() + stack.pop());
            } else if ('-' == ch) {
                stack.push(-stack.pop() + stack.pop());
            } else if ('*' == ch) {
                stack.push(stack.pop() * stack.pop());
            } else if ('/' == ch) {
                int divisor = stack.pop();
                int dividend = stack.pop();
                stack.push(dividend / divisor);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
