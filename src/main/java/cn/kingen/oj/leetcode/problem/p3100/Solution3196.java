package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximize-total-cost-of-alternating-subarrays/">3196. Maximize Total Cost of Alternating Subarrays</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM,
        contest = 403
)
public class Solution3196 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long dp = nums[0], dpp = 0, tmp;
        for (int i = 1; i < n; i++) {
            tmp = dp;
            dp = Math.max(dp + nums[i], dpp + nums[i - 1] - nums[i]);
            dpp = tmp;
        }
        return dp;
    }
}