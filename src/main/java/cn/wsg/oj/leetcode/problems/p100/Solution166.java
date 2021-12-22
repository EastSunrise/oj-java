package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 166. Fraction to Recurring Decimal (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/fraction-to-recurring-decimal/">Fraction to
 * Recurring Decimal</a>
 */
class Solution166 implements Solution {

    /**
     * Divides the denominator digit by digit with the numerator. The fractional part is repeating
     * if a remainder occurs before.
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            // negative result
            res.append("-");
        }
        // the integer part
        res.append(Math.abs((long) numerator / denominator));
        long remainder = numerator % denominator;
        if (remainder == 0) {
            // no fraction part
            return res.toString();
        }

        // appeared remainders
        List<Long> remainders = new ArrayList<>();
        Set<Long> occurrences = new HashSet<>();
        // fraction part
        List<Integer> fractions = new ArrayList<>();
        while (remainder != 0 && !occurrences.contains(remainder)) {
            occurrences.add(remainder);
            remainders.add(remainder);
            remainder *= 10;
            fractions.add((int) Math.abs(remainder / denominator));
            remainder %= denominator;
        }

        res.append(".");
        if (remainder == 0) {
            // no repeating part
            for (int fraction : fractions) {
                res.append(fraction);
            }
            return res.toString();
        }

        // recurring decimal
        // the start of the repeating part
        int idx = remainders.lastIndexOf(remainder);
        for (int i = 0; i < idx; i++) {
            res.append(fractions.get(i));
        }
        res.append("(");
        for (int i = idx; i < remainders.size(); i++) {
            res.append(fractions.get(i));
        }
        return res.append(")").toString();
    }
}
