package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 8. String to Integer (atoi) (Medium)
 *
 * @author Kingen
 * @see Solution7
 * @see Solution65
 * @see <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">String to Integer
 * (atoi)</a>
 */
public class Solution8 implements Solution {

    /**
     * Processes as the description, comparing with the two limits when adding the next digit.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int myAtoi(String s) {
        int i = 0, len = s.length();
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        char first = s.charAt(i);
        boolean positive = true;
        if (first == '+' || first == '-') {
            positive = first == '+';
            i++;
        }
        int limit = positive ? -Integer.MAX_VALUE : Integer.MIN_VALUE;
        int mulLimit = limit / 10;
        int value = 0;
        // handle as negative
        while (i < len) {
            int digit = s.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (value < mulLimit) {
                // exceed
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value *= 10;
            if (value < limit + digit) {
                // exceed
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value -= digit;
            i++;
        }
        return positive ? -value : value;
    }
}
