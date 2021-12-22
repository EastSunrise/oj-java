package cn.wsg.oj.leetcode.problems.interview.ch3;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 3.3. Stack of Plates LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/stack-of-plates-lcci/">Stack of Plates LCCI</a>
 */
public class Interview3 implements Solution {

    static class StackOfPlates {

        private final int capacity;
        private final LinkedList<Deque<Integer>> stacks;

        public StackOfPlates(int cap) {
            this.capacity = cap;
            this.stacks = new LinkedList<>();
        }

        public void push(int val) {
            if (capacity == 0) {
                return;
            }
            if (stacks.isEmpty() || stacks.getLast().size() == capacity) {
                stacks.addLast(new LinkedList<>());
            }
            stacks.getLast().push(val);
        }

        public int pop() {
            return popAt(stacks.size() - 1);
        }

        public int popAt(int index) {
            if (index < 0 || index >= stacks.size()) {
                return -1;
            }
            Deque<Integer> stack = stacks.get(index);
            int val = stack.pop();
            if (stack.isEmpty()) {
                stacks.remove(index);
            }
            return val;
        }
    }
}
