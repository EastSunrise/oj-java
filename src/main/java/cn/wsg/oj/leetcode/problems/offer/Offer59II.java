package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59-II. 队列的最大值 LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/">队列的最大值 LCOF</a>
 */
public class Offer59II implements Solution {

    static class MaxQueue {

        // the candidates of the maximal value in descending order
        private final Deque<Integer> candidates;
        private final Queue<Integer> values;

        public MaxQueue() {
            candidates = new LinkedList<>();
            values = new LinkedList<>();
        }

        public int max_value() {
            return candidates.isEmpty() ? -1 : candidates.getFirst();
        }

        public void push_back(int value) {
            while (!candidates.isEmpty() && value > candidates.getLast()) {
                candidates.removeLast();
            }
            candidates.offerLast(value);
            values.offer(value);
        }

        public int pop_front() {
            if (values.isEmpty()) {
                return -1;
            }
            int val = values.remove();
            if (candidates.getFirst() == val) {
                candidates.removeFirst();
            }
            return val;
        }
    }
}
