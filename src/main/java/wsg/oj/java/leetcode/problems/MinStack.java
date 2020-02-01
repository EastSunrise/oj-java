package wsg.oj.java.leetcode.problems;

import java.util.Stack;

/**
 * @author Kingen
 */
public class MinStack {

    private Stack<Integer> stack;
    private Integer min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (min == null || x < min)
            min = x;
        stack.push(x);
    }

    public void pop() {
        if (!stack.empty() && stack.pop().equals(min)) {
            min = null;
            for (Integer integer : stack) {
                if (min == null || integer < min)
                    min = integer;
            }
        }
    }

    public int top() {
        if (!stack.empty())
            return stack.peek();
        return -1;
    }

    public int getMin() {
        return min;
    }
}
