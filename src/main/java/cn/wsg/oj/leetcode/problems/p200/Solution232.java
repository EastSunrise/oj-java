package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 232. Implement Queue using Stacks (Easy)
 *
 * @author Kingen
 * @see Solution225
 * @see <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks/">Implement Queue
 * using Stacks</a>
 */
public class Solution232 implements Solution {

    static class MyQueue {

        private final Deque<Integer> stack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new LinkedList<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            stack.push(x);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.element();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
