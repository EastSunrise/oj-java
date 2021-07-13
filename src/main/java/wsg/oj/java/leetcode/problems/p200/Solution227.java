package wsg.oj.java.leetcode.problems.p200;

import java.util.Map;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 227. Basic Calculator II (Medium)
 *
 * @author Kingen
 * @see Solution224
 * @see Solution282
 * @see Solution772
 * @see <a href="https://leetcode-cn.com/problems/basic-calculator-ii/">Basic Calculator II</a>
 * @since 2021-07-13
 */
class Solution227 implements Solution {

    Map<Character, Integer> priorities = Map.of(
        '+', 2,
        '-', 2,
        '*', 4,
        '/', 4
    );

    /**
     * Uses a stack to store the operator with lower priority.
     *
     * @complexity S=O(L), L=levels of priorities=2
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                if (ch < '0' || ch > '9') {
                    int p = priorities.get(ch);
                    int operand2 = Integer.parseInt(builder.toString());
                    while (!operators.isEmpty() && p < priorities.get(operators.peek()) + 1) {
                        // calculate the previous operator with higher priority
                        operand2 = calculate(operators.pop(), operands.pop(), operand2);
                    }
                    operators.push(ch);
                    operands.push(operand2);
                    builder = new StringBuilder();
                } else {
                    builder.append(ch);
                }
            }
        }
        // calculate left operators
        int operand2 = Integer.parseInt(builder.toString());
        while (!operators.isEmpty()) {
            operand2 = calculate(operators.pop(), operands.pop(), operand2);
        }
        return operand2;
    }
}
