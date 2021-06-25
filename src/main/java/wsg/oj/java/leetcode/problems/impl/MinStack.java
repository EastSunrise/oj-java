package wsg.oj.java.leetcode.problems.impl;

import java.util.Stack;

/**
 * 155. Min Stack (Easy)
 *
 * @author Kingen
 * @date 2021/6/17
 * @see <a href="https://leetcode-cn.com/problems/min-stack/">Min Stack</a>
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

    public void push(int x) {
        if (min == null || x < min) {
            min = x;
        }
        delegate.push(x);
    }

    public void pop() {
        int top = delegate.pop();
        if (top == min) {
            min = null;
            for (Integer integer : delegate) {
                if (min == null || integer < min) {
                    min = integer;
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
