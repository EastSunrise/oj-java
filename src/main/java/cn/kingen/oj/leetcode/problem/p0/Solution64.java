package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/minimum-path-sum/">64. Minimum Path Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution62
 * @see cn.kingen.oj.leetcode.problem.p100.Solution174
 * @see cn.kingen.oj.leetcode.problem.p700.Solution741
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution64 {

    @Complexity(time = "O(mn)", space = "O(mn)")
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }
}