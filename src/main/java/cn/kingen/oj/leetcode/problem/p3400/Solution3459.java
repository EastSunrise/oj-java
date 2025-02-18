package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

/**
 * <a href="https://leetcode.cn/problems/length-of-longest-v-shaped-diagonal-segment/">3459. Length of Longest V-Shaped Diagonal Segment</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.HARD,
        contest = 437
)
public class Solution3459 {

    private static final int[][] D = {
            {-1, -1},
            {-1, 1},
            {1, 1},
            {1, -1}
    };

    @Complexity(time = "O(m*n)", space = "O(m*n)")
    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        int[][][][] memo = new int[m][n][4][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                for (int d = 0; d < 4; d++) {
                    ans = Math.max(ans, 1 + dfs(memo, grid, i + D[d][0], j + D[d][1], d, 1, 2));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][][][] memo, int[][] grid, int i, int j, int d, int turn, int val) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != val) {
            return 0;
        }
        if (memo[i][j][d][turn] != 0) {
            return memo[i][j][d][turn];
        }

        int len = dfs(memo, grid, i + D[d][0], j + D[d][1], d, turn, 2 - val);
        if (turn > 0) {
            int f = (d + 1) % 4;
            len = Math.max(len, dfs(memo, grid, i + D[f][0], j + D[f][1], f, turn - 1, 2 - val));
        }
        return memo[i][j][d][turn] = len + 1;
    }
}