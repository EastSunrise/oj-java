package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 754. Reach a Number (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reach-a-number/">Reach a Number</a>
 */
public class Solution754 implements Solution {

    /**
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int n = (int) Math.ceil(Math.sqrt(2D * target + 0.25) - 0.5);
        if ((n * (n + 1) / 2 - target) % 2 == 0) {
            return n;
        }
        return n + n % 2 + 1;
    }
}
