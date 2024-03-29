package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution464;

/**
 * 375. Guess Number Higher or Lower II (Medium)
 *
 * @author Kingen
 * @see Solution294
 * @see Solution374
 * @see Solution464
 * @see Solution658
 * @see <a href="https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/">Guess Number
 * Higher or Lower II</a>
 */
public class Solution375 implements Solution {

    /**
     * @see #TIME_NNN
     * @see #SPACE_NN
     */
    public int getMoneyAmount(int n) {
        // dp[i][j]: the minimal cost to guess right number from [i,j]
        int[][] dp = new int[n + 2][n + 1];
        for (int i = n; i > 0; i--) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    // the better choice is definitely in the right half
                    for (int k = (i + j) / 2; k <= j; k++) {
                        // the worse guess of the left and right subtree
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
                    }
                }
            }
        }
        return dp[1][n];
    }
}
