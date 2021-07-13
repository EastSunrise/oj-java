package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution264;

/**
 * 313. Super Ugly Number (Medium)
 *
 * @author Kingen
 * @see Solution264
 * @see <a href="https://leetcode-cn.com/problems/super-ugly-number/">Super Ugly Number</a>
 * @since 2021-07-13
 */
class Solution313 implements Solution {

    /**
     * @complexity T=O(nk), k=len(primes)
     * @complexity S=O(n+k)
     * @see #DYNAMIC_PROGRAMMING
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] indices = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = primes[0] * dp[indices[0]];
            int idx = 0;
            for (int p = 1; p < indices.length; p++) {
                int next = primes[p] * dp[indices[p]];
                if (next < dp[i]) {
                    dp[i] = next;
                    idx = p;
                }
            }
            indices[idx]++;
            if (dp[i] == dp[i - 1]) {
                i--;
            }
        }
        return dp[n - 1];
    }
}
