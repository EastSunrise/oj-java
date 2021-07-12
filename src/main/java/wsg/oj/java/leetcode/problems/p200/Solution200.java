package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution130;

/**
 * 200. Number of Islands (Medium)
 *
 * @author Kingen
 * @see Solution130
 * @see Solution286
 * @see Solution305
 * @see Solution323
 * @see Solution694
 * @see Solution695
 * @see Solution1905
 * @see <a href="https://leetcode-cn.com/problems/number-of-islands/">Number of Islands</a>
 * @since 2021-07-12
 */
public class Solution200 implements Solution {

    /**
     * @complexity S=O(s), s=the average area of islands
     * @see #DFS
     * @see wsg.oj.java.Complexity#TIME_MN
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    sinkIsland(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void sinkIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
            // out of index
            return;
        }
        if (grid[i][j] == '0') {
            // water or sank
            return;
        }
        grid[i][j] = '0';
        sinkIsland(grid, i - 1, j);
        sinkIsland(grid, i + 1, j);
        sinkIsland(grid, i, j - 1);
        sinkIsland(grid, i, j + 1);
    }
}
