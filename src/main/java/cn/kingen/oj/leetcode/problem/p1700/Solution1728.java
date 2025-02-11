package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/cat-and-mouse-ii/">1728. Cat and Mouse II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution789
 * @see cn.kingen.oj.leetcode.problem.p900.Solution913

 */
@Question(
    tags = {Tag.GRAPH, Tag.TOPOLOGICAL_SORT, Tag.MEMOIZATION, Tag.ARRAY, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.GAME_THEORY, Tag.MATRIX},
    difficulty = Difficulty.HARD,
    daily = "2025-02-11"
)
public class Solution1728 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int MAX_STEP = 1000;

    @Complexity(time = "O(m^2 * n^2 * (cj + mj))", space = "O(m * n * m * n * k)")
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int m = grid.length, n = grid[0].length();
        int cx = -1, cy = -1, mx = -1, my = -1;
        char[][] grid2 = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid2[i][j] = grid[i].charAt(j);
                if (grid2[i][j] == 'C') {
                    cx = i;
                    cy = j;
                } else if (grid2[i][j] == 'M') {
                    mx = i;
                    my = j;
                }
            }
        }
        return dfs(new int[m][n][m][n][MAX_STEP], grid2, cx, cy, catJump, mx, my, mouseJump, 1) == 1;
    }

    private int dfs(int[][][][][] memo, char[][] grid, int cx, int cy, int cj, int mx, int my, int mj, int k) {
        if ((cx == mx && cy == my) || grid[cx][cy] == 'F' || k == MAX_STEP) {
            return -1;
        }
        if (grid[mx][my] == 'F') {
            return 1;
        }
        if (memo[cx][cy][mx][my][k] != 0) {
            return memo[cx][cy][mx][my][k];
        }

        if ((k & 1) == 1) { // mouse turn
            if (dfs(memo, grid, cx, cy, cj, mx, my, mj, k + 1) == 1) {
                return memo[cx][cy][mx][my][k] = 1;
            }
            for (int[] d : DIRECTIONS) {
                int dx = d[0], dy = d[1], nx = mx, ny = my;
                for (int i = 0; i < mj; i++) {
                    nx += dx;
                    ny += dy;
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == '#') {
                        break;
                    }
                    if (dfs(memo, grid, cx, cy, cj, nx, ny, mj, k + 1) == 1) {
                        return memo[cx][cy][mx][my][k] = 1;
                    }
                }
            }
            return memo[cx][cy][mx][my][k] = -1;
        } else {
            if (dfs(memo, grid, cx, cy, cj, mx, my, mj, k + 1) == -1) {
                return memo[cx][cy][mx][my][k] = -1;
            }
            for (int[] d : DIRECTIONS) {
                int dx = d[0], dy = d[1], nx = cx, ny = cy;
                for (int i = 0; i < cj; i++) {
                    nx += dx;
                    ny += dy;
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == '#') {
                        break;
                    }
                    if (dfs(memo, grid, nx, ny, cj, mx, my, mj, k + 1) == -1) {
                        return memo[cx][cy][mx][my][k] = -1;
                    }
                }
            }
            return memo[cx][cy][mx][my][k] = 1;
        }
    }
}