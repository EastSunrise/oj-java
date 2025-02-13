package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-value-of-k-coins-from-piles/">2218. Maximum Value of K Coins From Piles</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution322
 * @see cn.kingen.oj.leetcode.problem.p500.Solution518

 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.PREFIX_SUM},
        difficulty = Difficulty.HARD,
        date = "2025-01-21"
)
public class Solution2218 {

    @Complexity(time = "O(nmk)", space = "O(nk)", note = "m is the average number of coins of each pile")
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        int c = 0;
        for (int i = 0; i < n; i++) {
            int m = piles.get(i).size();
            for (int j = 0, t = Math.min(k, c); j <= t; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
            }
            int sum = 0;
            for (int d = 1; d <= m; d++) { // d is the number of chosen coins in the current pile
                sum += piles.get(i).get(d - 1);
                for (int j = d, t = Math.min(k, c + d); j <= t; j++) { // j is the number of all chosen coins
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - d] + sum);
                }
            }
            c += m;
        }
        return dp[n][k];
    }
}