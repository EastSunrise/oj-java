package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/">239. Sliding Window Maximum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution76
 * @see cn.kingen.oj.leetcode.problem.p100.MinStack
 * @see cn.kingen.oj.leetcode.problem.p100.Solution159
 * @see cn.kingen.oj.leetcode.problem.p200.Solution265
 */
@Question(
        tags = {Tag.QUEUE, Tag.ARRAY, Tag.SLIDING_WINDOW, Tag.MONOTONIC_QUEUE, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution239 {

    /**
     * Maintain a queue to store monotonically decreasing numbers in the window.
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // queue to store monotonically decreasing numbers in the window: index and number
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast()[1] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(new int[]{i, nums[i]});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = deque.getFirst()[1];
        for (int i = k; i < n; i++) {
            // move right by one position
            while (!deque.isEmpty() && deque.peekLast()[1] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(new int[]{i, nums[i]});
            if (deque.getFirst()[0] <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = deque.getFirst()[1];
        }
        return ans;
    }
}