package cn.wsg.oj.leetcode.problems.p1200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1221. Split a String in Balanced Strings (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/">Split a
 * String in Balanced Strings</a>
 */
public class Solution1221 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
