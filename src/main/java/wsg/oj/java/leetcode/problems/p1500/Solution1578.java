package wsg.oj.java.leetcode.problems.p1500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1578. Minimum Deletion Cost to Avoid Repeating Letters (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/">Minimum
 * Deletion Cost to Avoid Repeating Letters</a>
 * @since 2021-07-27
 */
public class Solution1578 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minCost(String s, int[] cost) {
        int n = cost.length;
        int i = 0, total = 0;
        for (int j = 1; j < n; j++) {
            if (s.charAt(i) != s.charAt(j)) {
                i = j;
            } else if (cost[i] < cost[j]) {
                total += cost[i];
                i = j;
            } else {
                total += cost[j];
            }
        }
        return total;
    }
}
