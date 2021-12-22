package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 9. 用两个栈实现队列 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/">用两个栈实现队列
 * LCOF</a>
 */
public class Offer9 implements Solution {

    public static class CQueue {

        private final Deque<Integer> tail;
        private final Deque<Integer> head;

        public CQueue() {
            this.tail = new LinkedList<>();
            this.head = new LinkedList<>();
        }

        public void appendTail(int value) {
            tail.push(value);
        }

        public int deleteHead() {
            if (!head.isEmpty()) {
                return head.pop();
            }
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
            return head.isEmpty() ? -1 : head.pop();
        }
    }
}
