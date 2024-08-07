package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/dungeon-game/">174. Dungeon Game</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution62
 * @see cn.kingen.oj.leetcode.problem.p0.Solution64
 * @see cn.kingen.oj.leetcode.problem.p700.Solution741
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX},
        difficulty = Difficulty.HARD
)
public class Solution174 {

    /**
     * From bottom-right to top-left.
     */
    @Complexity(time = "O(mn)", space = "O(mn)")
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        // dp[i][j]: min hp from (i, j) to (m - 1, n - 1)
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}