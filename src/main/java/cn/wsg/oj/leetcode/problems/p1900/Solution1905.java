package cn.wsg.oj.leetcode.problems.p1900;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution200;

/**
 * 1905. Count Sub Islands (MEDIUM)
 *
 * @author Kingen
 * @see Solution200
 * @see Solution694
 * @see <a href="https://leetcode-cn.com/problems/count-sub-islands/">Count Sub Islands</a>
 */
public class Solution1905 implements Solution {

    /**
     * @see #DFS
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length, n = grid2[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length) {
            return true;
        }
        if (grid2[i][j] == 0) {
            return true;
        }
        grid2[i][j] = 0;
        boolean subIsland = grid1[i][j] == 1;
        subIsland &= dfs(grid1, grid2, i - 1, j);
        subIsland &= dfs(grid1, grid2, i + 1, j);
        subIsland &= dfs(grid1, grid2, i, j - 1);
        subIsland &= dfs(grid1, grid2, i, j + 1);
        return subIsland;
    }
}
