package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution282;

/**
 * 494. Target Sum (Medium)
 *
 * @author Kingen
 * @see Solution282
 * @see <a href="https://leetcode-cn.com/problems/target-sum/">Target Sum</a>
 */
public class Solution494 implements Solution {

    /**
     * @complexity T=O(n)
     * @complexity S=O(s), s=(sum+target)/2
     * @see #DYNAMIC_PROGRAMMING
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum += target;
        if ((sum & 1) == 1 || sum < 0) {
            return 0;
        }
        sum /= 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[sum];
    }
}
