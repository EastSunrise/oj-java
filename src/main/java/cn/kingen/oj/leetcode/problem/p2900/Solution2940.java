package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/find-building-where-alice-and-bob-can-meet/">2940. Find Building Where Alice and Bob Can Meet</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1944
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1642

 */
@Question(
    tags = {Tag.STACK, Tag.BINARY_INDEXED_TREE, Tag.SEGMENT_TREE, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.MONOTONIC_STACK,
        Tag.HEAP_PRIORITY_QUEUE},
    difficulty = Difficulty.HARD
)
public class Solution2940 {

    @Complexity(time = "O((m+n)*log(n))", space = "O(m+n)")
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        List<int[]> qs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int min = Math.min(a, b), max = Math.max(a, b);
            if (min == max || heights[min] < heights[max]) {
                ans[i] = max;
            } else {
                qs.add(new int[]{i, heights[min], max});
            }
        }
        qs.sort(Comparator.comparingInt(x -> x[2]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (int i = 0, j = 0; i < n; i++) {
            int height = heights[i];
            while (!pq.isEmpty() && pq.peek()[1] < height) {
                int[] q = pq.poll();
                ans[q[0]] = i;
            }
            while (j < qs.size() && qs.get(j)[2] == i) {
                pq.offer(qs.get(j++));
            }
        }
        return ans;
    }
}