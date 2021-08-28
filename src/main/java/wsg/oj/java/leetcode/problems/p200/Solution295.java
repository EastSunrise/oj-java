package wsg.oj.java.leetcode.problems.p200;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 295. Find Median from Data Stream (HARD)
 *
 * @author Kingen
 * @see Solution480
 * @see Solution1825
 * @see <a href="https://leetcode-cn.com/problems/find-median-from-data-stream/">Find Median from
 * Data Stream</a>
 * @since 2021-07-27
 */
public class Solution295 implements Solution {

    static class MedianFinder {

        /**
         * the maximum heap of the left half of sorted data.
         */
        Queue<Integer> left;
        /**
         * the minimum heap of the right half of sorted data.
         */
        Queue<Integer> right;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            this.left = new PriorityQueue<>(Comparator.reverseOrder());
            this.right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // 0 <= left.size() - right.size() <= 1
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
                if (left.size() - right.size() > 1) {
                    right.offer(left.poll());
                }
            } else {
                right.offer(num);
                if (left.size() < right.size()) {
                    left.offer(right.poll());
                }
            }
        }

        public double findMedian() {
            if (left.size() > right.size()) {
                return left.element();
            }
            return (left.element() + right.element()) / 2.0;
        }
    }
}
