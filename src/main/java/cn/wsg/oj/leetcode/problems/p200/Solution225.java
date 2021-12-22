package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues (Easy)
 *
 * @author Kingen
 * @see Solution232
 * @see <a href="https://leetcode-cn.com/problems/implement-stack-using-queues/">Implement Stack
 * using Queues</a>
 */
class Solution225 implements Solution {

    static class MyStack {

        private final Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            Queue<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                temp.add(queue.remove());
            }
            queue.add(x);
            while (!temp.isEmpty()) {
                queue.add(temp.remove());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.element();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
