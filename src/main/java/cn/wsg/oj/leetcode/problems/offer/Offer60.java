package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 60. n个骰子的点数  LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/">n个骰子的点数  LCOF</a>
 */
public class Offer60 implements Solution {

    /**
     * @complexity T=O(k^2 * n^2), k=the face number of a dice
     * @complexity S=O(k * n^2)
     */
    public double[] dicesProbability(int n) {
        // dp[i][v]: all possibilities of value v with i+1 dices
        int[][] dp = new int[n][6 * n + 1];
        for (int d = 1; d <= 6; d++) {
            dp[0][d] = 1;
        }
        for (int i = 1; i < n; i++) {
            // the value of this dice
            for (int d = 1; d <= 6; d++) {
                int max = 6 * i + d;
                for (int v = i + d; v <= max; v++) {
                    dp[i][v] += dp[i - 1][v - d];
                }
            }
        }
        int cnt = 5 * n + 1;
        double total = Math.pow(6, n);
        double[] ps = new double[cnt];
        int[] ndp = dp[n - 1];
        for (int i = 0; i < cnt; i++) {
            ps[i] = ndp[i + n] / total;
        }
        return ps;
    }
}
