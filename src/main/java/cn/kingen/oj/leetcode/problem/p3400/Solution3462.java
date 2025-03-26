package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-with-at-most-k-elements/">3462. Maximum Sum With at Most K Elements</a>
 *
 * @author Kingen

 */
@Question(
        difficulty = Difficulty.MEDIUM,
        contest = 438
)
public class Solution3462 {

    @Complexity(time = "O(n*m*log(m))", space = "O(n)")
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n = grid.length, m = grid[0].length;
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int i = 0; i < n; i++) {
            if (limits[i] > 0) {
                pq.offer(new int[]{i, m - 1, grid[i][m - 1]});
            }
        }
        long sum = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            int[] p = pq.poll();
            int i = p[0], j = p[1];
            limits[i]--;
            sum += p[2];

            j--;
            if (j >= 0 && limits[i] > 0) {
                pq.offer(new int[]{i, j, grid[i][j]});
            }
        }
        return sum;
    }
}