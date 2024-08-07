package cn.kingen.oj.leetcode.problem.p1100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Comparator;
import java.util.PriorityQueue;

import static cn.kingen.oj.leetcode.util.ArrayUtils.DIRECTIONS;

/**
 * <a href="https://leetcode.cn/problems/path-with-maximum-minimum-value/">1102. Path With Maximum Minimum Value</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1631
 */
@Question(
        paidOnly = true,
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.MATRIX, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1102 {

    @Complexity(time = "O(mn*log{mn})", space = "O(mn)")
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        // heap.peek(): [i of destination, j of destination, min value]
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));
        heap.offer(new int[]{0, 0, grid[0][0]});
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int i = cur[0], j = cur[1], min = cur[2];
            if (i == m - 1 && j == n - 1) {
                return min;
            }
            visited[i][j] = true;
            if (i + 1 < m && grid[i + 1][j] != -1) {
                heap.offer(new int[]{i + 1, j, Math.min(min, grid[i + 1][j])});
                grid[i + 1][j] = -1;
            }
            for (int[] offset : DIRECTIONS) {
                int x = i + offset[0], y = j + offset[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    heap.offer(new int[]{x, y, Math.min(min, grid[x][y])});
                }
            }
        }
        return -1;
    }
}