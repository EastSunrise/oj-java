package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Comparator;
import java.util.PriorityQueue;

import static cn.kingen.oj.leetcode.util.ArrayUtils.DIRECTIONS;

/**
 * <a href="https://leetcode.cn/problems/trapping-rain-water-ii/">407. Trapping Rain Water II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution42
 */
@Question(
        tags = {Tag.BREADTH_FIRST_SEARCH, Tag.ARRAY, Tag.MATRIX, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution407 {

    @Complexity(time = "O(m*n*log{m*n})", space = "O(m*n)")
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        // represent a circle of wall to trap water
        // heap[i]: (x, y, height)
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            heap.offer(new int[]{i, 0, heightMap[i][0]});
            heap.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
        }
        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            heap.offer(new int[]{0, j, heightMap[0][j]});
            heap.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
        }

        int ans = 0;
        while (!heap.isEmpty()) {
            int[] min = heap.poll();
            int x = min[0], y = min[1], h = min[2];
            for (int[] d : DIRECTIONS) {
                int i = x + d[0], j = y + d[1];
                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                    ans += Math.max(0, h - heightMap[i][j]);
                    visited[i][j] = true;
                    heap.offer(new int[]{i, j, Math.max(h, heightMap[i][j])});
                }
            }
        }
        return ans;
    }
}