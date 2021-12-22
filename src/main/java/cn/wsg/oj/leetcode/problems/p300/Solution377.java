package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution39;

/**
 * 377. Combination Sum IV (Medium)
 *
 * @author Kingen
 * @see Solution39
 * @see <a href="https://leetcode-cn.com/problems/combination-sum-iv/">Combination Sum IV</a>
 */
public class Solution377 implements Solution {

    /**
     * @complexity T=O(nk), k=target
     * @complexity S=O(k)
     * @see #DYNAMIC_PROGRAMMING
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
