package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

/**
 * <a href="https://leetcode.cn/problems/sum-of-k-subarrays-with-length-at-least-m/">3473. Sum of K Subarrays With Length at Least M</a>
 *
 * @author Kingen

 */
@Question(
        difficulty = Difficulty.MEDIUM,
        contest = 439
)
public class Solution3473 {

    @Complexity(time = "O(kn)", space = "O(kn)")
    public int maxSum(int[] nums, int k, int m) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int t = 1; t <= k; t++) {
            dp[t][t * m] = prefix[t * m]; // exactly nums[0,t*m-1]
            int max = dp[t][t * m]; // max{dp[t-1][i-m-j]+prefix[i]-prefix[i-m-j]}, 0<=j<=i-tm
            for (int i = t * m + 1; i <= n; i++) {
                max = Math.max(max + nums[i - 1], dp[t - 1][i - m] + prefix[i] - prefix[i - m]);
                dp[t][i] = Math.max(dp[t][i - 1], max);
            }
        }
        return dp[k][n];
    }
}