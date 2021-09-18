package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 960. Delete Columns to Make Sorted III (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/delete-columns-to-make-sorted-iii/">Delete Columns
 * to Make Sorted III</a>
 * @since 2021-07-27
 */
public class Solution960 implements Solution {

    /**
     * @complexity T=O(m*n^2), m=size of the array
     * @complexity S=O(n)
     */
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int[] dp = new int[n];
        int max = 1;
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
            for (int i = 0; i < j; i++) {
                boolean ascending = true;
                for (String str : strs) {
                    if (str.charAt(i) > str.charAt(j)) {
                        ascending = false;
                        break;
                    }
                }
                if (ascending) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            max = Math.max(max, dp[j]);
        }
        return n - max;
    }
}
