package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 880. Decoded String at Index (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/decoded-string-at-index/">Decoded String at
 * Index</a>
 * @since 2021-07-27
 */
public class Solution880 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public String decodeAtIndex(String s, int k) {
        long len = 0;
        int i = 0, n = s.length();
        while (i < n) {
            char ch = s.charAt(i++);
            if (isDigit(ch)) {
                len *= (ch - '0');
                if (len >= k) {
                    break;
                }
            } else {
                len++;
            }
        }
        k--;
        while (--i >= 0) {
            char ch = s.charAt(i);
            if (isDigit(ch)) {
                len /= ch - '0';
                k %= len;
            } else {
                len--;
                if (k == len) {
                    return ch + "";
                }
            }
        }
        return "";
    }
}
