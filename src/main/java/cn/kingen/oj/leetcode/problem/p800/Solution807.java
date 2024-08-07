package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/max-increase-to-keep-city-skyline/">807. Max Increase to Keep City Skyline</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution807 {

    @Complexity(time = "O(mn)", space = "O(m+n)")
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] maxRows = new int[m], maxCols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxRows[i] = Math.max(maxRows[i], grid[i][j]);
                maxCols[j] = Math.max(maxCols[j], grid[i][j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(maxRows[i], maxCols[j]) - grid[i][j];
            }
        }
        return sum;
    }
}