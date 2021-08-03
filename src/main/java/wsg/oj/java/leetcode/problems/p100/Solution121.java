package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution53;
import wsg.oj.java.leetcode.problems.p300.Solution309;

/**
 * 121. Best Time to Buy and Sell Stock (Easy)
 *
 * @author Kingen
 * @see Solution53
 * @see Solution122
 * @see Solution123
 * @see Solution188
 * @see Solution309
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy
 * and Sell Stock</a>
 * @since 2021-07-11
 */
public class Solution121 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxProfit(int[] prices) {
        // min: the min price within prices[0,i-1]
        int min = prices[0], max = 0, n = prices.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
