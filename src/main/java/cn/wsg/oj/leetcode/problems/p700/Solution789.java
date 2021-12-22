package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1700.Solution1728;

/**
 * 789. Escape The Ghosts (MEDIUM)
 *
 * @author Kingen
 * @see Solution1728
 * @see <a href="https://leetcode-cn.com/problems/escape-the-ghosts/">Escape The Ghosts</a>
 */
public class Solution789 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= distance) {
                return false;
            }
        }
        return true;
    }
}
