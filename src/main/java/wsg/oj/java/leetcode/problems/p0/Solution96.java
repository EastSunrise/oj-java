package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 96. Unique Binary Search Trees (Medium)
 *
 * @author Kingen
 * @see Solution95
 * @see <a href="https://leetcode-cn.com/problems/unique-binary-search-trees/">Unique Binary Search
 * Trees</a>
 * @since 2021-07-11
 */
class Solution96 implements Solution {

    /**
     * Catalan number G(n): G(n+1)=G(0)*G(n)+G(1)*G(n-1)+...+G(n)*G(0).
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                dp[k] += dp[i] * dp[k - 1 - i];
            }
        }
        return dp[n];
    }
}
