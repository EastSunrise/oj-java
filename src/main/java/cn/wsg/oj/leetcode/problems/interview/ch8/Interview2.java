package cn.wsg.oj.leetcode.problems.interview.ch8;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 8.2. Robot in a Grid LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/robot-in-a-grid-lcci/">Robot in a Grid LCCI</a>
 */
public class Interview2 implements Solution {

    /**
     * @see #BACKTRACKING
     */
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        List<List<Integer>> path = new ArrayList<>(m + n - 1);
        for (int i = 1; i < m + n; i++) {
            path.add(null);
        }
        return dfs(path, 0, obstacleGrid, 0, 0) ? path : new ArrayList<>();
    }

    private boolean dfs(List<List<Integer>> path, int i, int[][] grid, int r, int c) {
        if (r >= grid.length || c >= grid[0].length) {
            return false;
        }
        if (grid[r][c] > 0) {
            // visited or blocked
            return false;
        }
        path.set(i++, List.of(r, c));
        if (i == path.size()) {
            // reach the bottom right corner
            return true;
        }
        // marked as visited
        grid[r][c] = 2;
        return dfs(path, i, grid, r + 1, c) || dfs(path, i, grid, r, c + 1);
    }
}
