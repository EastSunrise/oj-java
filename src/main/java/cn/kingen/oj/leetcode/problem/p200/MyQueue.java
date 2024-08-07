package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/">232. Implement Queue using Stacks</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.MyStack
 */
@Question(
        tags = {Tag.STACK, Tag.DESIGN, Tag.QUEUE},
        difficulty = Difficulty.EASY
)
public class MyQueue {

    private final Stack<Integer> input;
    private final Stack<Integer> output;

    @Complexity(time = "O(1)", space = "O(n)")
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public void push(int x) {
        output.push(x);
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int pop() {
        rearrange();
        return input.pop();
    }

    private void rearrange() {
        if (input.isEmpty()) {
            while (!output.isEmpty()) {
                input.push(output.pop());
            }
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int peek() {
        rearrange();
        return input.peek();
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean empty() {
        return input.isEmpty() && output.empty();
    }
}