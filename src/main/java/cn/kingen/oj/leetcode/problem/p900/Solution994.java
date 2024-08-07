package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Queue;

import static cn.kingen.oj.leetcode.util.ArrayUtils.DIRECTIONS;

/**
 * <a href="https://leetcode.cn/problems/rotting-oranges/">994. Rotting Oranges</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution286
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2101
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2258
 */
@Question(
        tags = {Tag.BREADTH_FIRST_SEARCH, Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution994 {

    @Complexity(time = "O(m*n)", space = "O(m*n)")
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        int bits = 16, mask = 0xffff;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer((i << bits) + j);
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cell = queue.remove();
                int i = cell >> bits, j = mask & cell;
                for (int[] d : DIRECTIONS) {
                    int x = i + d[0], y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer((x << bits) + y);
                    }
                }
            }
            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return -1;
                }
            }
        }
        return minutes;
    }
}