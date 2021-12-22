package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 481. Magical String (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/magical-string/">Magical String</a>
 */
public class Solution481 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
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
