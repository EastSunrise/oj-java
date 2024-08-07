package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/min-stack/">155. Min Stack</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution239
 * @see cn.kingen.oj.leetcode.problem.p700.Solution716
 */
@Question(
        tags = {Tag.STACK, Tag.DESIGN},
        difficulty = Difficulty.MEDIUM
)
public class MinStack {

    private final Deque<Integer> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
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