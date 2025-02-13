package cn.kingen.oj.leetcode.problem.p2400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-money-required-before-transactions/">2412. Minimum Money Required
 * Before Transactions</a>
 *
 * @author Kingen
 */
@Question(
    tags = {Tag.GREEDY, Tag.ARRAY, Tag.SORTING},
    difficulty = Difficulty.HARD,
        date = "2025-01-25"
)
public class Solution2412 {

    /**
     * For any lost transaction, x >= l+c where l is total lose before and c is the cost of this transaction. If this is
     * the last lost transaction, x >= l+c = tl-(c-b)+c = tl+b where tl is total lose and b is the max back cost.
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public long minimumMoney(int[][] transactions) {
        long totalLose = 0, maxCost = 0, maxBack = 0;
        for (int[] transaction : transactions) {
            if (transaction[0] > transaction[1]) {
                totalLose += transaction[0] - transaction[1];
                maxBack = Math.max(maxBack, transaction[1]);
            } else {
                maxCost = Math.max(maxCost, transaction[0]);
            }
        }
        return totalLose + Math.max(maxCost, maxBack);
    }
}