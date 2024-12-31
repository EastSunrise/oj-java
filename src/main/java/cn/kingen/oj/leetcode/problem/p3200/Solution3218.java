package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-cost-for-cutting-cake-i/">3218. Minimum Cost for Cutting Cake I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3200.Solution3219
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3218 {

    @Complexity(time = "O(m*log(m)+n*log(n)+m*n)", space = "O(m*n)")
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        // dp[i][j] is the cost of (i+1)x(j+1) cake
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = horizontalCut[i - 1] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = verticalCut[j - 1] + dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(
                        dp[i - 1][j] + dp[0][j] + horizontalCut[i - 1],
                        dp[i][j - 1] + dp[i][0] + verticalCut[j - 1]
                );
            }
        }
        return dp[m - 1][n - 1];
    }
}