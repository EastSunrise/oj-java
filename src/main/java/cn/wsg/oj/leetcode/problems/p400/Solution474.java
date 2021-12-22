package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p600.Solution600;

/**
 * 474. Ones and Zeroes (Medium)
 *
 * @author Kingen
 * @see Solution600
 * @see <a href="https://leetcode-cn.com/problems/ones-and-zeroes/">Ones and Zeroes</a>
 */
public class Solution474 implements Solution {

    /**
     * @complexity T=O(lmn+L), l=the length of the array, L=sum(len(str))
     * @complexity S=O(mn)
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[j][k]: the size of the largest subset of strs[0,i] with at most j 0's and k 1's.
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            // traverse in reverse order to compare with the dp result of strs[0,i-1]
            // instead of ones just updated
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
