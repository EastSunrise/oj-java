package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 166. Fraction to Recurring Decimal (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/fraction-to-recurring-decimal/">Fraction to
 * Recurring Decimal</a>
 * @since 2021-07-12
 */
class Solution166 implements Solution {

    /**
     * Divides the denominator digit by digit with the numerator. The fractional part is repeating
     * if a remainder occurs before.
     */
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if (numerator != 0 && (numerator < 0 ^ denominator < 0)) {
            // negative
            res.append("-");
        }
        // the integer part
        res.append(Math.abs(((long) numerator / denominator)));
        long remainder = numerator % denominator;
        if (remainder == 0) {
            return res.toString();
        }
        res.append(".");
        // appeared remainders
        List<Long> remainders = new ArrayList<>();
        // fraction part
        List<Integer> fractions = new ArrayList<>();
        do {
            int idx = remainders.lastIndexOf(remainder);
            if (idx >= 0) {
                // recurring decimal
                for (int i = 0; i < idx; i++) {
                    res.append(fractions.get(i));
                }
                res.append("(");
                for (int i = idx; i < remainders.size(); i++) {
                    res.append(fractions.get(i));
                }
                return res.append(")").toString();
            }
            remainders.add(remainder);
            remainder *= 10;
            fractions.add((int) Math.abs(remainder / denominator));
            remainder = remainder % denominator;
        } while (remainder != 0);
        for (int fraction : fractions) {
            res.append(fraction);
        }
        return res.toString();
    }
}
