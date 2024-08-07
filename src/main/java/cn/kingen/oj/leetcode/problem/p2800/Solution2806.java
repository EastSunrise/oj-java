package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/account-balance-after-rounded-purchase/">2806. Account Balance After Rounded Purchase</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution2806 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int remainder = purchaseAmount % 10;
        purchaseAmount = remainder < 5 ? purchaseAmount - remainder : purchaseAmount + 10 - remainder;
        return 100 - purchaseAmount;
    }
}