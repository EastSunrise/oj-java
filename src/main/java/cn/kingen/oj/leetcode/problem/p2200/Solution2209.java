package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/">2209. Minimum White Tiles After Covering With Carpets</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution72

 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING, Tag.PREFIX_SUM},
        difficulty = Difficulty.HARD,
        date = "2025-02-21"
)
public class Solution2209 {

    @Complexity(time = "O(n*m)", space = "O(n*m)", note = "m is the number of carpets")
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        // dp[i][j] is the minimum number of white tiles after covering floor[0,i-1] with j carpets
        int[][] dp = new int[n + 1][numCarpets + 1];
        for (int i = 1; i <= n; i++) {
            int tile = floor.charAt(i - 1) - '0';
            dp[i][0] = dp[i - 1][0] + tile;
            for (int j = 1, max = Math.min(i / carpetLen, numCarpets); j <= max; j++) {
                dp[i][j] = dp[i - 1][j] + tile; // not cover
                if (tile == 1) { // cover with a carpet
                    dp[i][j] = Math.min(dp[i][j], dp[i - carpetLen][j - 1]);
                }
            }
        }
        return dp[n][numCarpets];
    }
}