package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 789. Escape The Ghosts (MEDIUM)
 *
 * @author Kingen
 * @see Solution1728
 * @see <a href="https://leetcode-cn.com/problems/escape-the-ghosts/">Escape The Ghosts</a>
 * @since 2021-07-27
 */
public class Solution789 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
