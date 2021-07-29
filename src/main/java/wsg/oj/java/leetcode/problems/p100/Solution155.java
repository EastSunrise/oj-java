package wsg.oj.java.leetcode.problems.p100;

import java.util.Deque;
import java.util.LinkedList;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution239;

/**
 * 155. Min Stack (Easy)
 *
 * @author Kingen
 * @see Solution239
 * @see Solution716
 * @see <a href="https://leetcode-cn.com/problems/min-stack/">Min Stack</a>
 * @since 2021-07-12
 */
public class Solution155 implements Solution {

    static class MinStack {

        private final Deque<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
        }

        public void push(int val) {
            int min = stack.isEmpty() ? val : Math.min(val, stack.element());
            stack.push(val);
            stack.push(min);
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            int min = stack.pop();
            int top = stack.element();
            stack.push(min);
            return top;
        }

        public int getMin() {
            return stack.element();
        }
    }
}
