package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 807. Max Increase to Keep City Skyline (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/">Max Increase
 * to Keep City Skyline</a>
 */
public class Solution807 implements Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] maxRows = new int[m], maxCols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxRows[i] = Math.max(maxRows[i], grid[i][j]);
                maxCols[j] = Math.max(maxCols[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(maxRows[i], maxCols[j]) - grid[i][j];
            }
        }
        return res;
    }
}
