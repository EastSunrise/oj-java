package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/">150. Evaluate Reverse Polish Notation</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution224
 * @see cn.kingen.oj.leetcode.problem.p200.Solution282
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution150 {

    /**
     * Uses a stack to store the operands and the results.
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
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