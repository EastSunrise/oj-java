package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/">225. Implement Stack using Queues</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.MyQueue
 */
@Question(
        tags = {Tag.STACK, Tag.DESIGN, Tag.QUEUE},
        difficulty = Difficulty.EASY
)
public class MyStack {

    private final Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    @Complexity(time = "O(n)", space = "O(1)")
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        while (n-- > 0) {
            queue.offer(queue.remove());
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int pop() {
        return queue.remove();
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int top() {
        return queue.element();
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean empty() {
        return queue.isEmpty();
    }
}