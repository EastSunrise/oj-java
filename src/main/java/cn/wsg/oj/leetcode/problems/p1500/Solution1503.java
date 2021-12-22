package cn.wsg.oj.leetcode.problems.p1500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1503. Last Moment Before All Ants Fall Out of a Plank (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/">Last
 * Moment Before All Ants Fall Out of a Plank</a>
 */
public class Solution1503 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = -1;
        for (int i : left) {
            max = Math.max(max, i);
        }
        for (int i : right) {
            max = Math.max(max, n - i);
        }
        return max;
    }
}
