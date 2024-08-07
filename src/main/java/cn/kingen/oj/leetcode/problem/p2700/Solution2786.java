package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/visit-array-positions-to-maximize-score/">2786. Visit Array Positions to Maximize Score</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution45
 * @see cn.kingen.oj.leetcode.problem.p800.Solution877
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2786 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long maxScore(int[] nums, int x) {
        long ans = nums[0];
        long[] dp = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] % 2] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i], bit = num % 2;
            long max = Math.max(dp[bit] + num, dp[1 - bit] + num - x);
            ans = Math.max(ans, max);
            dp[bit] = Math.max(dp[bit], max);
        }
        return ans;
    }
}