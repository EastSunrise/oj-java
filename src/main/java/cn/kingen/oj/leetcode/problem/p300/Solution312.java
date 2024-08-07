package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/burst-balloons/">312. Burst Balloons</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1000
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution312 {

    @Complexity(time = "O(n^3)", space = "O(n^2)")
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] = arr[n + 1] = 1;
        // dp[i][j]: the max coins of bursting balloons in nums(i,j).
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);

                }
            }
        }
        return dp[0][n + 1];
    }
}