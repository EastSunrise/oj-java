package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution200;
import wsg.oj.java.leetcode.problems.p400.Solution463;

/**
 * 695. Max Area of Island (MEDIUM)
 *
 * @author Kingen
 * @see Solution200
 * @see Solution463
 * @see Solution1727
 * @see <a href="https://leetcode-cn.com/problems/max-area-of-island/">Max Area of Island</a>
 * @since 2021-07-23
 */
public class Solution695 implements Solution {

    /**
     * @see #DFS
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r + 1, c);
        area += dfs(grid, r, c - 1);
        area += dfs(grid, r, c + 1);
        return area;
    }
}
