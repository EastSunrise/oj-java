package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution239;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. Min Stack (Easy)
 *
 * @author Kingen
 * @see Solution239
 * @see Solution716
 * @see <a href="https://leetcode-cn.com/problems/min-stack/">Min Stack</a>
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
