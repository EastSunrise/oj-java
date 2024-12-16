package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/">862. Shortest Subarray with Sum at Least K</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3097
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3095
 */
@Question(
        tags = {Tag.QUEUE, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.PREFIX_SUM, Tag.SLIDING_WINDOW, Tag.MONOTONIC_QUEUE, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD,
        contest = 91
)
public class Solution862 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        // indices of numbers in ascending order
        int[] queue = new int[n + 1];
        int s = 0, t = 0, ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            while (s <= t && prefixSums[i] - prefixSums[queue[s]] >= k) {
                ans = Math.min(ans, i - queue[s++]);
            }
            while (s <= t && prefixSums[queue[t]] >= prefixSums[i]) {
                t--;
            }
            queue[++t] = i;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}