package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/">3176. Find the Maximum Length of a Good Subsequence I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution300
 * @see cn.kingen.oj.leetcode.problem.p700.Solution718
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3176 {

    @Complexity(time = "O(n^2*k)", space = "O(n*k)")
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // dp[t]: good subsequence ending with nums[i] with exactly t differences
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            dp[i][0] = 1; // only nums[i]
            for (int j = 0; j < i; j++) { // ...,num[j],num[i]
                if (num == nums[j]) {
                    for (int t = 0; t <= k; t++) {
                        dp[i][t] = Math.max(dp[i][t], dp[j][t] + 1);
                    }
                } else {
                    for (int t = 1; t <= k; t++) {
                        dp[i][t] = Math.max(dp[i][t], dp[j][t - 1] + 1);
                    }
                }
            }
            for (int t = 0; t <= k; t++) {
                ans = Math.max(ans, dp[i][t]);
            }
        }
        return ans;
    }
}