package wsg.oj.java.hanoi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * A stack whose values are in ascending order from top to bottom.
 *
 * @author Kingen
 */
public class AscendingStack {

    private final Deque<Integer> stack;

    public AscendingStack() {
        this.stack = new LinkedList<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || stack.peek() < val) {
            stack.push(val);
            return;
        }
        throw new IllegalArgumentException("Not asc.");
    }

    public int pop() {
        return stack.pop();
    }

    public int size() {
        return stack.size();
    }
}
