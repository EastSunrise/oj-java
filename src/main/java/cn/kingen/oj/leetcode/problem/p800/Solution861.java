package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/score-after-flipping-matrix/">861. Score After Flipping Matrix</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2128
 */
@Question(
        tags = {Tag.GREEDY, Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM,
        contest = 91
)
public class Solution861 {

    @Complexity(time = "O(m*n)", space = "O(1)")
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) { // flip the row
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        for (int j = 1; j < n; j++) {
            int ones = 0;
            for (int[] row : grid) {
                ones += row[j];
            }
            if (ones < m - ones) { // flip the column
                for (int[] row : grid) {
                    row[j] = 1 - row[j];
                }
            }
        }

        int ans = 0;
        for (int[] row : grid) {
            int val = 0;
            for (int j = 0; j < n; j++) {
                val = val << 1 | row[j];
            }
            ans += val;
        }
        return ans;
    }
}