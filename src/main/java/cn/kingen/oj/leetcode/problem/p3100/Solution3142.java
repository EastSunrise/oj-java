package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/check-if-grid-satisfies-conditions/">3142. Check if Grid Satisfies Conditions</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution135
 * @see cn.kingen.oj.leetcode.problem.p500.Solution575
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2144
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.EASY
)
public class Solution3142 {

    @Complexity(time = "O(mn)", space = "O(1)")
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 1; j < n; j++) {
            if (grid[0][j] == grid[0][j - 1]) {
                return false;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != grid[i - 1][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}