package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.gcd;
import static java.lang.Character.isDigit;

/**
 * <a href="https://leetcode.cn/problems/fraction-addition-and-subtraction/">592. Fraction Addition and Subtraction</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution640
 */
@Question(
        tags = {Tag.MATH, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution592 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String fractionAddition(String expression) {
        int n = expression.length();
        int numerator = 0, denominator = 1;
        for (int i = 0; i < n; ) {
            int k = expression.indexOf('/', i);
            int num = Integer.parseInt(expression.substring(i, k));
            i = k + 1;
            while (i < n && isDigit(expression.charAt(i))) {
                i++;
            }
            int den = Integer.parseInt(expression.substring(k + 1, i));
            numerator = numerator * den + num * denominator;
            denominator = den * denominator;
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        return numerator + "/" + denominator;
    }
}