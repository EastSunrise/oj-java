package cn.wsg.oj.leetcode.problems.interview.ch17;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 面试题 17.23. Max Black Square LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/max-black-square-lcci/">Max Black Square LCCI</a>
 */
public class Interview23 implements Solution {

    public int[] findSquare(int[][] matrix) {
        int n = matrix.length;
        // dp[i][j]: the side length of maximal blank square
        // with matrix[i-1][j-1] as its lower right corner
        int[][] dp = new int[n + 1][n + 1];
        int[] res = new int[3];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    if (dp[i][j] > res[2]) {
                        res[0] = i;
                        res[1] = j;
                        res[2] = dp[i][j];
                    }
                }
            }
        }
        if (res[2] == 0) {
            return new int[0];
        }
        res[0] = res[0] - res[2];
        res[1] = res[1] - res[2];
        return res;
    }
}
