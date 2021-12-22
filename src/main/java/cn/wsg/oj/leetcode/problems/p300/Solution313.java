package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution264;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 313. Super Ugly Number (Medium)
 *
 * @author Kingen
 * @see Solution264
 * @see <a href="https://leetcode-cn.com/problems/super-ugly-number/">Super Ugly Number</a>
 */
public class Solution313 implements Solution {

    /**
     * @complexity T=O(n*log{k})
     * @complexity S=O(n+k)
     * @see #DYNAMIC_PROGRAMMING
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        // candidates of next super ugly number
        // a candidate: the index of the previous one, the prime, the value of the candidate
        Queue<int[]> candidates = new PriorityQueue<>(k, Comparator.comparingInt(o -> o[2]));
        for (int prime : primes) {
            candidates.offer(new int[]{0, prime, prime});
        }
        // the first n super ugly numbers
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ) {
            // choose the minimal candidate as the ith super ugly number
            // if it is larger than the previous one
            int[] min = candidates.remove();
            if (min[2] > dp[i - 1]) {
                dp[i++] = min[2];
            }
            // update the minimal candidate
            min[0]++;
            min[2] = dp[min[0]] * min[1];
            candidates.offer(min);
        }
        return dp[n - 1];
    }
}
