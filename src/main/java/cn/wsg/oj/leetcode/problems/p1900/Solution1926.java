package cn.wsg.oj.leetcode.problems.p1900;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. Nearest Exit from Entrance in Maze (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/nearest-exit-from-entrance-in-maze/">Nearest Exit
 * from Entrance in Maze</a>
 */
public class Solution1926 implements Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    /**
     * @see #BFS
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+';
        queue.offer(entrance);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.remove();
                for (int j = 0; j < 4; j++) {
                    int r = pos[0] + dr[j], c = pos[1] + dc[j];
                    if (r < 0 || r >= m || c < 0 || c >= n || maze[r][c] == '+') {
                        // out of index or visited or a wall
                        continue;
                    }
                    if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
                        // reach the border
                        return step;
                    }
                    // marked as visited
                    maze[r][c] = '+';
                    queue.offer(new int[]{r, c});
                }
            }
            step++;
        }
        return -1;
    }
}
