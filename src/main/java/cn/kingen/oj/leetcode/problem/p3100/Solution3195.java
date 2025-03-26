package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-minimum-area-to-cover-all-ones-i/">3195. Find the Minimum Area to Cover All Ones I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution302
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM,
        contest = 403
)
public class Solution3195 {

    @Complexity(time = "O(m*n)", space = "O(1)")
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int top = m - 1, left = n - 1, right = 0, bottom = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    bottom = Math.max(bottom, i);
                }
            }
        }
        return (right - left + 1) * (bottom - top + 1);
    }
}