package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/stone-game/">877. Stone Game</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1563
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1686
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1690
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1872
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2029
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2396
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2786
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.GAME_THEORY},
        difficulty = Difficulty.MEDIUM
)
public class Solution877 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j]: the maximal difference of stones the two players can take from piles[i,j]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0, max = n - k; i < max; i++) {
                // piles[i, i+k]
                int j = i + k;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}