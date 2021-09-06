package wsg.oj.java.leetcode.problems.lcp;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 17. 速算机器人 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/nGK0Fy/">速算机器人</a>
 * @since 2021-07-28
 */
public class Lcp17 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int calculate(String s) {
        return 1 << s.length();
    }
}
