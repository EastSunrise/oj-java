package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution698;

/**
 * 416. Partition Equal Subset Sum (Medium)
 *
 * @author Kingen
 * @see Solution698
 * @see <a href="https://leetcode-cn.com/problems/partition-equal-subset-sum/">Partition Equal
 * Subset Sum</a>
 * @since 2021-07-07
 */
public class Solution416 implements Solution {

    /**
     * @complexity T=O(ns), s=sum/2
     * @complexity S=O(s)
     * @see #DYNAMIC_PROGRAMMING
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >>> 1;
        // dp[j]: whether there is a subarray of nums whose sum is j.
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            // add this number
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
