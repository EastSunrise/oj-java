package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution640;

/**
 * 592. Fraction Addition and Subtraction (MEDIUM)
 *
 * @author Kingen
 * @see Solution640
 * @see <a href="https://leetcode-cn.com/problems/fraction-addition-and-subtraction/">Fraction
 * Addition and Subtraction</a>
 * @since 2021-07-20
 */
public class Solution592 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public String fractionAddition(String expression) {
        int n = expression.length();
        int numerator = 0, denominator = 1, start = 0;
        while (start < n) {
            int i = expression.indexOf('/', start);
            int num = Integer.parseInt(expression.substring(start, i));
            start = i + 1;
            while (start < n && isDigit(expression.charAt(start))) {
                start++;
            }
            int den = Integer.parseInt(expression.substring(i + 1, start));
            numerator = numerator * den + num * denominator;
            denominator = den * denominator;
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        return numerator + "/" + denominator;
    }
}
