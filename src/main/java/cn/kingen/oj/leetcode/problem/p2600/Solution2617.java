package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/">2617. Minimum Number of Visited Cells in a Grid</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution45
 * @see cn.kingen.oj.leetcode.problem.p0.Solution55
 */
@Question(
        tags = {Tag.STACK, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX, Tag.MONOTONIC_STACK, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution2617 {

    @Complexity(time = "O(mn(logm+logn))", space = "O(mn)")
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<PriorityQueue<int[]>> cols = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cols.add(new PriorityQueue<>(Comparator.comparingInt(a -> a[1])));
        }
        PriorityQueue<int[]> row = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int k, cells = 1;
        for (int i = 0; i < m; i++) {
            row.clear();
            for (int j = 0; j < n; j++) {
                while (!row.isEmpty() && (k = row.element()[0]) + grid[i][k] < j) {
                    row.poll();
                }
                while (!cols.get(j).isEmpty() && (k = cols.get(j).element()[0]) + grid[k][j] < i) {
                    cols.get(j).poll();
                }

                cells = (i == 0 && j == 0) ? 1 : Integer.MAX_VALUE;
                if (!row.isEmpty()) {
                    cells = row.element()[1] + 1;
                }
                if (!cols.get(j).isEmpty()) {
                    cells = Math.min(cells, cols.get(j).element()[1] + 1);
                }

                if (grid[i][j] > 0 && cells != Integer.MAX_VALUE) {
                    row.offer(new int[]{j, cells});
                    cols.get(j).offer(new int[]{i, cells});
                }
            }
        }
        return cells == Integer.MAX_VALUE ? -1 : cells;
    }
}