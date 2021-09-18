package wsg.oj.java.leetcode.problems.p200;

import java.util.Deque;
import java.util.LinkedList;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution76;
import wsg.oj.java.leetcode.problems.p100.Solution155;

/**
 * 239. Sliding Window Maximum (HARD)
 *
 * @author Kingen
 * @see Solution76
 * @see Solution155
 * @see Solution159
 * @see Solution265
 * @see Solution1696
 * @see <a href="https://leetcode-cn.com/problems/sliding-window-maximum/">Sliding Window
 * Maximum</a>
 * @since 2021-07-27
 */
public class Solution239 implements Solution {

    /**
     * Maintains a monotonously-decreasing queue.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // the values are in descending order
        Deque<Integer> indices = new LinkedList<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k - 1; i++) {
            while (!indices.isEmpty() && nums[i] >= nums[indices.getLast()]) {
                indices.removeLast();
            }
            indices.addLast(i);
        }
        for (int i = k - 1; i < n; i++) {
            while (!indices.isEmpty() && nums[i] >= nums[indices.getLast()]) {
                indices.removeLast();
            }
            indices.addLast(i);
            if (indices.getFirst() + k <= i) {
                indices.removeFirst();
            }
            res[i - k + 1] = nums[indices.getFirst()];
        }
        return res;
    }
}
