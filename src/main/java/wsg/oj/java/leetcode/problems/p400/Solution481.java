package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 481. Magical String (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/magical-string/">Magical String</a>
 * @since 2021-07-09
 */
class Solution481 implements Solution {

    public int magicalString(int n) {
        char ch = '1';
        int dx = 1, ones = 1;
        StringBuilder builder = new StringBuilder("122");
        for (int i = 2; i < n; i++) {
            if (builder.charAt(i) == '2') {
                builder.append(ch).append(ch);
            } else {
                ones++;
                builder.append(ch);
            }
            ch += dx;
            dx = -dx;
        }
        return ones;
    }
}
