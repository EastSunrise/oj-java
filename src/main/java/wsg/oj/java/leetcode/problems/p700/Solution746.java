package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution70;

/**
 * 746. Min Cost Climbing Stairs (EASY)
 *
 * @author Kingen
 * @see Solution70
 * @see <a href="https://leetcode-cn.com/problems/min-cost-climbing-stairs/">Min Cost Climbing
 * Stairs</a>
 * @since 2021-07-26
 */
public class Solution746 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int prev = cost[0], cur = cost[1];
        for (int i = 2; i < len; i++) {
            int next = Math.min(prev + cost[i], cur + cost[i]);
            prev = cur;
            cur = next;
        }
        return Math.min(prev, cur);
    }
}
