package wsg.oj.java.leetcode.problems.p500;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution496;

/**
 * 556. Next Greater Element III (MEDIUM)
 *
 * @author Kingen
 * @see Solution496
 * @see Solution503
 * @see Solution1842
 * @see <a href="https://leetcode-cn.com/problems/next-greater-element-iii/">Next Greater Element
 * III</a>
 * @since 2021-07-20
 */
public class Solution556 implements Solution {

    public int nextGreaterElement(int n) {
        Deque<Integer> deque = new LinkedList<>();
        int digit = n % 10;
        do {
            deque.addLast(digit);
            n /= 10;
        } while (n > 0 && (digit = n % 10) >= deque.getLast());
        if (n == 0) {
            return -1;
        }
        n /= 10;
        Queue<Integer> smaller = new LinkedList<>();
        while (deque.getFirst() <= digit) {
            smaller.add(deque.removeFirst());
        }
        smaller.add(digit);
        n = n * 10 + deque.removeFirst();
        int last = Integer.MAX_VALUE % 10, mulLimit = Integer.MAX_VALUE / 10;
        while (!smaller.isEmpty()) {
            if (n > mulLimit) {
                return -1;
            }
            int d = smaller.remove();
            if (n == mulLimit && d > last) {
                return -1;
            }
            n = n * 10 + d;
        }
        while (!deque.isEmpty()) {
            if (n > mulLimit) {
                return -1;
            }
            int d = deque.removeFirst();
            if (n == mulLimit && d > last) {
                return -1;
            }
            n = n * 10 + d;
        }
        return n;
    }
}
