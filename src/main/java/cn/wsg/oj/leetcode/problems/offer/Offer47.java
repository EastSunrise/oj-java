package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 47. 礼物的最大价值 LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/">礼物的最大价值 LCOF</a>
 */
public class Offer47 implements Solution {

    /**
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // dp[i][j]: the maximal value from [0,0] to [i-1,j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
