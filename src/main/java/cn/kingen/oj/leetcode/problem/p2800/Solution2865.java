package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/beautiful-towers-i/">2865. Beautiful Towers I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution941
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1671
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2355
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.MEDIUM
)
public class Solution2865 {

    @Complexity(time = "O(n^2)", space = "O(1)")
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size(), i = 0;
        long ans = 0;
        while (i < n) {
            while (i < n - 1 && maxHeights.get(i) <= maxHeights.get(i + 1)) {
                i++;
            }
            int leftMax = maxHeights.get(i), rightMax = maxHeights.get(i);
            long sum = maxHeights.get(i);
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.min(leftMax, maxHeights.get(j));
                sum += leftMax;
            }
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.min(rightMax, maxHeights.get(j));
                sum += rightMax;
            }
            ans = Math.max(ans, sum);
            i++;
            while (i < n - 1 && maxHeights.get(i) >= maxHeights.get(i + 1)) {
                i++;
            }
        }
        return ans;
    }

    /**
     * Uses monotonic stack.
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public long maximumSumOfHeights_2(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] maxPrefixSums = new long[n], maxSuffixSums = new long[n];
        Deque<Integer> prefix = new ArrayDeque<>(n), suffix = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            int maxHeight = maxHeights.get(i);
            while (!prefix.isEmpty() && maxHeight < maxHeights.get(prefix.peek())) {
                prefix.pop();
            }
            if (prefix.isEmpty()) {
                maxPrefixSums[i] = (long) (i + 1) * maxHeight;
            } else {
                maxPrefixSums[i] = maxPrefixSums[prefix.peek()] + (long) (i - prefix.peek()) * maxHeight;
            }
            prefix.push(i);
        }
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int maxHeight = maxHeights.get(i);
            while (!suffix.isEmpty() && maxHeight < maxHeights.get(suffix.peek())) {
                suffix.pop();
            }
            if (suffix.isEmpty()) {
                maxSuffixSums[i] = (long) (n - i) * maxHeight;
            } else {
                maxSuffixSums[i] = maxSuffixSums[suffix.peek()] + (long) (suffix.peek() - i) * maxHeight;
            }
            suffix.push(i);
            ans = Math.max(ans, maxPrefixSums[i] + maxSuffixSums[i] - maxHeight);
        }
        return ans;
    }
}