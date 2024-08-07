package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/">857. Minimum Cost to Hire K Workers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2542
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution857 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] s = new Integer[n];
        Arrays.setAll(s, i -> i);
        Arrays.sort(s, (i, j) -> Integer.compare(wage[i] * quality[j], wage[j] * quality[i]));

        PriorityQueue<Integer> heap = new PriorityQueue<>((p, q) -> q - p);
        double q = 0.0;
        for (int i = 0; i < k - 1; i++) {
            q += quality[s[i]];
            heap.offer(quality[s[i]]);
        }

        double ans = Double.MAX_VALUE;
        for (int i = k - 1; i < n; i++) {
            int idx = s[i];
            q += quality[idx];
            heap.offer(quality[idx]);
            ans = Math.min(ans, q * ((double) wage[idx] / quality[idx]));
            q -= heap.remove();
        }
        return ans;
    }
}