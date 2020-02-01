package wsg.oj.java.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kingen
 */
public class MyStack {

    private Queue<Integer> queue;

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
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = queue.size();
        int value;
        for (int i = 1; i < size; i++) {
            value = queue.poll();
            queue.offer(value);
        }
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int size = queue.size();
        int value = 0;
        for (int i = 0; i < size; i++) {
            value = queue.poll();
            queue.offer(value);
        }
        return value;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
