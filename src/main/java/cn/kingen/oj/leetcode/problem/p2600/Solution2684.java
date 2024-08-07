package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/">2684. Maximum Number of Moves in a Grid</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution2684 {

    @Complexity(time = "O(mn)", space = "O(mn)")
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = true;
        }

        int ans = 0;
        for (int col = 1; col < n; col++) {
            for (int row = m - 1; row >= 0; row--) {
                dp[row][col] = dp[row][col - 1] && grid[row][col] > grid[row][col - 1];
                if (row > 0) {
                    dp[row][col] |= dp[row - 1][col - 1] && grid[row][col] > grid[row - 1][col - 1];
                }
                if (row < m - 1) {
                    dp[row][col] |= dp[row + 1][col - 1] && grid[row][col] > grid[row + 1][col - 1];
                }
                if (dp[row][col]) {
                    ans = col;
                }
            }
            if (ans != col) {
                break;
            }
        }
        return ans;
    }
}