package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/time-needed-to-buy-tickets/">2073. Time Needed to Buy Tickets</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1700
 */
@Question(
        tags = {Tag.QUEUE, Tag.ARRAY, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution2073 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int ans = 0, ticket = tickets[k];
        for (int i = 0; i <= k; i++) {
            ans += Math.min(ticket, tickets[i]);
        }
        for (int i = k + 1; i < n; i++) {
            ans += Math.min(ticket - 1, tickets[i]);
        }
        return ans;
    }
}