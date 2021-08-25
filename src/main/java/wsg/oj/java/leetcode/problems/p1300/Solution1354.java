package wsg.oj.java.leetcode.problems.p1300;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1354. Construct Target Array With Multiple Sums (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/construct-target-array-with-multiple-sums/">Construct
 * Target Array With Multiple Sums</a>
 * @since 2021-07-27
 */
public class Solution1354 implements Solution {

    /**
     * @complexity T=O(n*log{m}), m=the maximum of target
     * @complexity S=O(n)
     */
    public boolean isPossible(int[] target) {
        int n = target.length;
        if (n == 1) {
            return target[0] == 1;
        }
        Queue<Integer> heap = new PriorityQueue<>(n, Comparator.reverseOrder());
        long sum = 0;
        for (int num : target) {
            heap.offer(num);
            sum += num;
        }
        while (heap.element() != 1) {
            int max = heap.remove();
            long other = sum - max;
            if (other == 1) {
                return true;
            }
            if (max <= other) {
                return false;
            }
            long replace = max % other;
            if (replace == 0) {
                return false;
            }
            heap.offer((int) replace);
            sum = replace + other;
        }
        return true;
    }
}
