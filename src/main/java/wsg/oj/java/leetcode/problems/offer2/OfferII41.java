package wsg.oj.java.leetcode.problems.offer2;

import java.util.ArrayDeque;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer II 41. 滑动窗口的平均值 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/qIsx9U/">滑动窗口的平均值</a>
 * @since 2021-08-29
 */
public class OfferII41 implements Solution {

    static class MovingAverage {

        private final int capacity;
        private final Queue<Integer> values;
        private int sum;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.capacity = size;
            this.values = new ArrayDeque<>(capacity);
        }

        public double next(int val) {
            if (values.size() == capacity) {
                sum -= values.remove();
            }
            values.offer(val);
            sum += val;
            return sum * 1.0 / values.size();
        }
    }
}
