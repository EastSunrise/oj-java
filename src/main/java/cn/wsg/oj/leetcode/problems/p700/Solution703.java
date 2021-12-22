package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution215;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 703. Kth Largest Element in a Stream (EASY)
 *
 * @author Kingen
 * @see Solution215
 * @see Solution1825
 * @see <a href="https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/">Kth Largest
 * Element in a Stream</a>
 */
public class Solution703 implements Solution {

    static class KthLargest {

        private final int k;
        private final Queue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            queue.offer(val);
            if (queue.size() > k) {
                queue.remove();
            }
            return queue.element();
        }
    }
}
