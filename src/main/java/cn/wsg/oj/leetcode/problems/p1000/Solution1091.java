package cn.wsg.oj.leetcode.problems.p1000;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/">Shortest Path in
 * Binary Matrix</a>
 */
public class Solution1091 implements Solution {

    int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

    /**
     * @see #BFS
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 0) {
            queue.offer(new int[]{0, 0});
            // marked as visited
            grid[0][0] = 1;
        }
        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.remove();
                // find the destination
                if (pos[0] == n - 1 && pos[1] == n - 1) {
                    return len;
                }
                for (int j = 0; j < 8; j++) {
                    int r = pos[0] + dr[j], c = pos[1] + dc[j];
                    if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0) {
                        queue.offer(new int[]{r, c});
                        // marked as visited
                        grid[r][c] = 1;
                    }
                }
            }
            len++;
        }
        return -1;
    }
}
