package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 696. Count Binary Substrings (EASY)
 *
 * @author Kingen
 * @see Solution271
 * @see <a href="https://leetcode-cn.com/problems/count-binary-substrings/">Count Binary
 * Substrings</a>
 * @since 2021-07-23
 */
class Solution696 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int countBinarySubstrings(String s) {
        char prev = '^';
        int prevCount = 0, count = 0, res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == prev) {
                count++;
            } else {
                res += Math.min(prevCount, count);
                prevCount = count;
                count = 1;
                prev = ch;
            }
        }
        res += Math.min(prevCount, count);
        return res;
    }
}
