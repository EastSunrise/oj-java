package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 329. Longest Increasing Path in a Matrix (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/">Longest
 * Increasing Path in a Matrix</a>
 */
public class Solution329 implements Solution {

    /**
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] calculated = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, calculated, -1, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] calculated, int prev, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }
        if (matrix[i][j] <= prev) {
            return 0;
        }
        if (calculated[i][j] != 0) {
            return calculated[i][j];
        }
        int max = 0;
        max = Math.max(max, dfs(matrix, calculated, matrix[i][j], i - 1, j));
        max = Math.max(max, dfs(matrix, calculated, matrix[i][j], i + 1, j));
        max = Math.max(max, dfs(matrix, calculated, matrix[i][j], i, j - 1));
        max = Math.max(max, dfs(matrix, calculated, matrix[i][j], i, j + 1));
        calculated[i][j] = max + 1;
        return max + 1;
    }
}
