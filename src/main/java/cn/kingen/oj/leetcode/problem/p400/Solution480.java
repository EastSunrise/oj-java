package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-median/">480. Sliding Window Median</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.MedianFinder
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3107
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.SLIDING_WINDOW, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution480 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> large = new PriorityQueue<>();
        Map<Integer, Integer> removed = new HashMap<>();
        int[] size = new int[2];
        for (int i = 0; i < k - 1; i++) {
            add(removed, small, large, size, nums[i]);
        }

        boolean odd = k % 2 == 1;
        double[] ans = new double[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            add(removed, small, large, size, nums[i]);

            if (odd) {
                ans[i - k + 1] = small.element();
            } else {
                ans[i - k + 1] = ((double) small.element() + large.element()) / 2;
            }

            // remove nums[i - k + 1]
            int num0 = nums[i - k + 1];
            removed.put(num0, removed.getOrDefault(num0, 0) + 1);
            if (num0 <= small.element()) {
                size[0]--;
                prune(removed, small);
            } else {
                size[1]--;
                prune(removed, large);
            }
            balance(removed, small, large, size);
        }
        return ans;
    }

    private void add(Map<Integer, Integer> removed, PriorityQueue<Integer> small, PriorityQueue<Integer> large, int[] size, int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            size[0]++;
        } else {
            large.offer(num);
            size[1]++;
        }
        balance(removed, small, large, size);
    }

    private void balance(Map<Integer, Integer> removed, PriorityQueue<Integer> small, PriorityQueue<Integer> large, int[] size) {
        if (size[0] > size[1] + 1) {
            large.offer(small.poll());
            size[0]--;
            size[1]++;
            prune(removed, small);
        } else if (size[0] < size[1]) {
            small.offer(large.poll());
            size[0]++;
            size[1]--;
            prune(removed, large);
        }
    }

    private void prune(Map<Integer, Integer> removed, PriorityQueue<Integer> heap) {
        int cnt;
        while (!heap.isEmpty() && (cnt = removed.getOrDefault(heap.peek(), 0)) > 0) {
            removed.put(heap.poll(), cnt - 1);
        }
    }
}