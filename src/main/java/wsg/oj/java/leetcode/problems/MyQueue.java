package wsg.oj.java.leetcode.problems;

import java.util.Stack;

/**
 * @author Kingen
 */
public class MyQueue {

    private Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty())
            temp.push(stack.pop());
        int first = temp.pop();
        while (!temp.empty())
            stack.push(temp.pop());
        return first;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty())
            temp.push(stack.pop());
        int first = temp.peek();
        while (!temp.empty())
            stack.push(temp.pop());
        return first;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.empty();
    }
}
