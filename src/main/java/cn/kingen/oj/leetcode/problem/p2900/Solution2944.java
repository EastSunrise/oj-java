package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-coins-for-fruits/">2944. Minimum Number of Coins for Fruits</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.QUEUE, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MONOTONIC_QUEUE, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM,
        date = "2025-01-24"
)
public class Solution2944 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[][] queue = new int[n + 1][2]; // ascending stack
        int s = 0, t = 0, ans = 0;
        for (int i = 1; i <= n; i++) {
            int start = (i + 1) >> 1;
            while (s < t && queue[s][0] < start) {
                s++;
            }
            int notBuy = s < t ? queue[s][1] : Integer.MAX_VALUE;
            int buy = ans + prices[i - 1];
            ans = Math.min(buy, notBuy);

            while (s < t && queue[t - 1][1] >= buy) {
                t--;
            }
            queue[t++] = new int[]{i, buy};
        }
        return ans;
    }
}