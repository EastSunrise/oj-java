package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/solve-the-equation/">640. Solve the Equation</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution592
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2232
 */
@Question(tags = {Tag.MATH, Tag.STRING, Tag.SIMULATION}, difficulty = Difficulty.MEDIUM)
public class Solution640 {

    @Complexity(time = "O(n)", space = "O(1)")
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

    /**
     * @return coefficient k of x and constant b
     */
    private int[] parseCoefficient(String exp) {
        int k = 0, b = 0, sign = 1;
        for (int i = 0, n = exp.length(); i < n; ) {
            int j = i, num = 0, ch;
            while (j < n && (ch = exp.charAt(j)) != '+' && ch != '-' && ch != 'x') {
                j++;
                num = num * 10 + (ch - '0');
            }
            if (j == n || exp.charAt(j) != 'x') { // constant
                b += sign * num;
            } else { // coefficient of x
                if (i == j) {
                    num = 1;
                }
                k += sign * num;
                j++;
            }
            if (j < n) {
                sign = exp.charAt(j) == '+' ? 1 : -1;
            }
            i = j + 1;
        }
        return new int[]{k, b};
    }
}