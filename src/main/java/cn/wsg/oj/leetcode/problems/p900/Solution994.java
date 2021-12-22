package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges (MEDIUM)
 *
 * @author Kingen
 * @see Solution286
 * @see <a href="https://leetcode-cn.com/problems/rotting-oranges/">Rotting Oranges</a>
 */
public class Solution994 implements Solution {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    /**
     * @see #BFS
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
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
            for (int i = 0; i < size; i++) {
                int cell = queue.remove();
                int r0 = cell >> bits, c0 = mask & cell;
                for (int j = 0; j < 4; j++) {
                    int r = r0 + dr[j], c = c0 + dc[j];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.offer((r << bits) + c);
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
