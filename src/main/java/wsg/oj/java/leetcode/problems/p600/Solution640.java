package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution592;

/**
 * 640. Solve the Equation (MEDIUM)
 *
 * @author Kingen
 * @see Solution592
 * @see <a href="https://leetcode-cn.com/problems/solve-the-equation/">Solve the Equation</a>
 * @since 2021-07-23
 */
public class Solution640 implements Solution {

    public String solveEquation(String equation) {
        int i = equation.indexOf('=');
        int[] left = parseCoefficient(equation.substring(0, i));
        int[] right = parseCoefficient(equation.substring(i + 1));
        if (left[0] == right[0]) {
            if (left[1] == right[1]) {
                return "Infinite solutions";
            }
            return "No solution";
        }
        return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
    }

    private int[] parseCoefficient(String exp) {
        int x = 0, c = 0;
        int start = 0;
        while (start < exp.length()) {
            int i = start + 1;
            // find next operator
            while (i < exp.length() && exp.charAt(i) != '+' && exp.charAt(i) != '-') {
                i++;
            }
            if (exp.charAt(i - 1) != 'x') {
                // constant
                c += Integer.parseInt(exp.substring(start, i));
            } else {
                int coefficient = 1;
                if (exp.charAt(start) == '+') {
                    start++;
                } else if (exp.charAt(start) == '-') {
                    coefficient = -1;
                    start++;
                }
                if (start < i - 1) {
                    // not like x, +x, -x
                    coefficient *= Integer.parseInt(exp.substring(start, i - 1));
                }
                x += coefficient;
            }
            start = i;
        }
        return new int[]{x, c};
    }
}
