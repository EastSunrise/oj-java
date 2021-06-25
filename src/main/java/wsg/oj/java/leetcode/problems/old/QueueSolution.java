package wsg.oj.java.leetcode.problems.old;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kingen
 */
public class QueueSolution {

    public int numIslands(char[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;
        if (width == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] index = queue.poll();
                        grid[index[0]][index[1]] = '0';
                        if (index[0] + 1 < height && grid[index[0] + 1][index[1]] == '1') {
                            queue.offer(new int[]{index[0] + 1, index[1]});
                        }
                        if (index[0] - 1 >= 0 && grid[index[0] - 1][index[1]] == '1') {
                            queue.offer(new int[]{index[0] - 1, index[1]});
                        }
                        if (index[1] + 1 < width && grid[index[0]][index[1] + 1] == '1') {
                            queue.offer(new int[]{index[0], index[1] + 1});
                        }
                        if (index[1] - 1 >= 0 && grid[index[0]][index[1] - 1] == '1') {
                            queue.offer(new int[]{index[0], index[1] - 1});
                        }
                    }
                }
            }
        }
        return count;
    }
}
