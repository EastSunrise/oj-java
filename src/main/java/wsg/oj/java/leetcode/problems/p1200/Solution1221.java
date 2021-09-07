package wsg.oj.java.leetcode.problems.p1200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1221. Split a String in Balanced Strings (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/">Split a
 * String in Balanced Strings</a>
 * @since 2021-07-27
 */
public class Solution1221 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int balancedStringSplit(String s) {
        int left = 0, cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                left++;
            } else {
                left--;
            }
            if (left == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
