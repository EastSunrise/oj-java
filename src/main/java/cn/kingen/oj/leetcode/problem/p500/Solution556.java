package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-iii/">556. Next Greater Element III</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution496
 * @see cn.kingen.oj.leetcode.problem.p500.Solution503
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1842
 */
@Question(
        tags = {Tag.MATH, Tag.TWO_POINTERS, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution556 {

    @Complexity(time = "O(log(n))", space = "O(log(n))")
    public int nextGreaterElement(int n) {
        Deque<Integer> deque = new ArrayDeque<>(32);
        int digit = n % 10;
        do {
            deque.addLast(digit);
            n /= 10;
        } while (n > 0 && (digit = n % 10) >= deque.getLast());
        if (n == 0) {
            return -1;
        }

        n /= 10;
        Queue<Integer> smaller = new ArrayDeque<>();
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