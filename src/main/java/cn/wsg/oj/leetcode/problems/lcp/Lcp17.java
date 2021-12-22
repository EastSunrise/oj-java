package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * LCP 17. 速算机器人 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/nGK0Fy/">速算机器人</a>
 */
public class Lcp17 implements Solution {

    /**
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     */
    public int calculate(String s) {
        return 1 << s.length();
    }
}
