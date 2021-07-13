package wsg.oj.java.leetcode.problems.p200;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution95;

/**
 * 241. Different Ways to Add Parentheses (Medium)
 *
 * @author Kingen
 * @see Solution95
 * @see Solution224
 * @see Solution282
 * @see <a href="https://leetcode-cn.com/problems/different-ways-to-add-parentheses/">Different Ways
 * to Add Parentheses</a>
 * @since 2021-07-13
 */
public class Solution241 implements Solution {

    /**
     * @complexity T=O(G(n)), n=count of operators, G(n) is Catalan number
     * @complexity S=O(G(n))
     * @see #DIVIDE_AND_CONQUER
     */
    public List<Integer> diffWaysToCompute(String expression) {
        return calculate(expression.toCharArray(), 0, expression.length());
    }

    private List<Integer> calculate(char[] chars, int fromIn, int toEx) {
        List<Integer> res = new ArrayList<>();
        for (int i = fromIn; i < toEx; i++) {
            if (!isDigit(chars[i])) {
                List<Integer> left = calculate(chars, fromIn, i);
                List<Integer> right = calculate(chars, i + 1, toEx);
                for (int operand1 : left) {
                    for (int operand2 : right) {
                        res.add(calculate(chars[i], operand1, operand2));
                    }
                }
            }
        }
        if (res.isEmpty()) {
            // all chars in the range are digits
            return List.of(Integer.parseInt(String.valueOf(chars, fromIn, toEx - fromIn)));
        }
        return res;
    }
}
