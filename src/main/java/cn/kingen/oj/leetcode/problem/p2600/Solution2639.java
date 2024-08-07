package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-width-of-columns-of-a-grid/">2639. Find the Width of Columns of a Grid</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2048
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.EASY
)
public class Solution2639 {

    @Complexity(time = "O(mn)", space = "O(n)")
    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int[] row : grid) {
                max = Math.max(max, row[j]);
                min = Math.min(min, row[j]);
            }
            ans[j] = Math.max(String.valueOf(max).length(), String.valueOf(min).length());
        }
        return ans;
    }
}