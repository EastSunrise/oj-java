package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution70;

/**
 * 746. Min Cost Climbing Stairs (EASY)
 *
 * @author Kingen
 * @see Solution70
 * @see <a href="https://leetcode-cn.com/problems/min-cost-climbing-stairs/">Min Cost Climbing
 * Stairs</a>
 */
public class Solution746 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int minCostClimbingStairs(int[] cost) {
        int prev = cost[0], cur = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int next = Math.min(prev + cost[i], cur + cost[i]);
            prev = cur;
            cur = next;
        }
        return Math.min(prev, cur);
    }
}
