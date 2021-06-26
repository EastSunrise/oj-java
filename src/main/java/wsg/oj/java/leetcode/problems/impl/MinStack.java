package wsg.oj.java.leetcode.problems.impl;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.Solution201;

/**
 * 155. Min Stack (Easy)
 *
 * @author Kingen
 * @see Solution201#maxSlidingWindow(int[], int)
 * @see MaxStack
 * @see <a href="https://leetcode-cn.com/problems/min-stack/">Min Stack</a>
 * @since 2021-06-25
 */
public class MinStack {

    private final Stack<Integer> delegate;
    private Integer min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        delegate = new Stack<>();
    }

    public void push(int val) {
        delegate.push(val);
        if (min == null || val < min) {
            min = val;
        }
    }

    public void pop() {
        int top = delegate.pop();
        if (top == min) {
            min = null;
            for (int val : delegate) {
                if (min == null || val < min) {
                    min = val;
                }
            }
        }
    }

    public int top() {
        return delegate.peek();
    }

    public int getMin() {
        return min;
    }
}
