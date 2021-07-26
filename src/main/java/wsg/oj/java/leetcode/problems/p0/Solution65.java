package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 65. Valid Number (HARD)
 *
 * @author Kingen
 * @see Solution8
 * @see <a href="https://leetcode-cn.com/problems/valid-number/">Valid Number</a>
 * @since 2021-07-19
 */
public class Solution65 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int e = s.indexOf('e');
        if (e < 0) {
            e = s.indexOf('E');
        }
        if (e < 0) {
            // xxx
            return isDecimal(s);
        }
        if (e == 0 || e == len - 1) {
            // Exx or xxxE
            return false;
        }
        // xxxExx
        return isDecimal(s.substring(0, e)) && isInteger(s.substring(e + 1));
    }

    /**
     * Checks whether the string is a valid decimal or a valid integer
     */
    private boolean isDecimal(String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        int dot = s.indexOf('.');
        if (dot < 0) {
            // an integer
            return isUnsignedInteger(s);
        }
        if (dot == 0) {
            // .xxx
            return isUnsignedInteger(s.substring(1));
        }
        if (dot == s.length() - 1) {
            // xxx.
            return isUnsignedInteger(s.substring(0, s.length() - 1));
        }
        // xxx.xxx
        return isUnsignedInteger(s.substring(0, dot)) && isUnsignedInteger(s.substring(dot + 1));
    }

    private boolean isInteger(String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        return isUnsignedInteger(s);
    }

    private boolean isUnsignedInteger(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (char ch : s.toCharArray()) {
            if (!isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
