package wsg.oj.java.leetcode.problems.lcp;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 7. 传递信息 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/chuan-di-xin-xi/">传递信息</a>
 * @since 2021-07-28
 */
public class Lcp7 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int numWays(int n, int[][] relation, int k) {
        // dp[i][j]: the number of ways to transmit the message to i after j rounds
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] rel : relation) {
                dp[rel[1]][i] += dp[rel[0]][i - 1];
            }
        }
        return dp[n - 1][k];
    }
}
