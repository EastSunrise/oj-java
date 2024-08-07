package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/paint-house-ii/">265. Paint House II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution238
 * @see cn.kingen.oj.leetcode.problem.p200.Solution239
 * @see cn.kingen.oj.leetcode.problem.p200.Solution256
 * @see cn.kingen.oj.leetcode.problem.p200.Solution276
 */
@Question(
        paidOnly = true,
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution265 {

    @Complexity(time = "O(n*k)", space = "O(k)", note = "k is the number of colors")
    public int minCostII(int[][] costs) {
        int k = costs[0].length;
        int[] dp = new int[k];
        for (int[] cost : costs) {
            int min = Math.min(dp[0], dp[1]), secondMin = Math.max(dp[0], dp[1]);
            for (int i = 2; i < k; i++) {
                if (dp[i] <= min) {
                    secondMin = min;
                    min = dp[i];
                } else if (dp[i] < secondMin) {
                    secondMin = dp[i];
                }
            }
            for (int i = 0; i < k; i++) {
                if (dp[i] == min) {
                    dp[i] = secondMin + cost[i];
                } else {
                    dp[i] = min + cost[i];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}