package wsg.oj.java.leetcode.problems.p700;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 787. Cheapest Flights Within K Stops (MEDIUM)
 *
 * @author Kingen
 * @see Solution568
 * @see <a href="https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/">Cheapest Flights
 * Within K Stops</a>
 * @since 2021-07-27
 */
public class Solution787 implements Solution {

    /**
     * @complexity T=O(k*|E|)
     * @complexity S=O(k*n)
     * @see #DYNAMIC_PROGRAMMING
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp[u][i]: the minimal cost from src to u with i stops
        int[][] dp = new int[n][k + 1];
        for (int[] path : dp) {
            Arrays.fill(path, 0xfffffff);
        }
        for (int i = 0; i <= k; i++) {
            dp[src][i] = 0;
        }
        for (int[] flight : flights) {
            if (flight[0] == src) {
                dp[flight[1]][0] = flight[2];
            }
        }
        for (int i = 1; i <= k; i++) {
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1];
                dp[v][i] = Math.min(dp[v][i], dp[u][i - 1] + flight[2]);
            }
        }
        return dp[dst][k] == 0xfffffff ? -1 : dp[dst][k];
    }
}
