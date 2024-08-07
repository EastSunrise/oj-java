package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/selling-pieces-of-wood/">2312. Selling Pieces of Wood</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1240
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1444
 */
@Question(
        tags = {Tag.MEMOIZATION, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution2312 {

    @Complexity(time = "O(mn(m+n)+p)", space = "O(mn)", note = "p is the length of prices")
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] price : prices) {
            dp[price[0]][price[1]] = price[2];
        }
        for (int h = 1; h <= m; h++) {
            for (int w = 1; w <= n; w++) {
                for (int k = 1; k <= h / 2; k++) {
                    dp[h][w] = Math.max(dp[h][w], dp[k][w] + dp[h - k][w]);
                }
                for (int k = 1; k <= w / 2; k++) {
                    dp[h][w] = Math.max(dp[h][w], dp[h][k] + dp[h][w - k]);
                }
            }
        }
        return dp[m][n];
    }
}