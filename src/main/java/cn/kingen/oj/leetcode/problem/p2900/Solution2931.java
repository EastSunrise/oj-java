package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/maximum-spending-after-buying-items/">2931. Maximum Spending After Buying Items</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1423
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1770
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.MATRIX, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution2931 {

    @Complexity(time = "O(mn*log(m))", space = "O(m)")
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, n - 1, values[i][n - 1]});
        }

        long ans = 0, d = 1;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            ans += p[2] * d;

            if (p[1] > 0) {
                pq.offer(new int[]{p[0], p[1] - 1, values[p[0]][p[1] - 1]});
            }
            d++;
        }
        return ans;
    }
}