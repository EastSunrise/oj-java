package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayDeque;
import java.util.Deque;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 402. Remove K Digits (Medium)
 *
 * @author Kingen
 * @see Solution321
 * @see Solution738
 * @see Solution1673
 * @see <a href="https://leetcode-cn.com/problems/remove-k-digits/">Remove K Digits</a>
 * @since 2021-07-06
 */
class Solution402 implements Solution {

    /**
     * Builds a monotonic queue.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        Deque<Character> queue = new ArrayDeque<>(num.length() - k);
        for (char ch : num.toCharArray()) {
            while (k > 0 && !queue.isEmpty() && ch < queue.peekLast()) {
                queue.pollLast();
                k--;
            }
            queue.offerLast(ch);
        }
        while (k-- > 0) {
            queue.pollLast();
        }
        while (!queue.isEmpty() && queue.peekFirst() == '0') {
            queue.pollFirst();
        }
        if (queue.isEmpty()) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (Character ch : queue) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
