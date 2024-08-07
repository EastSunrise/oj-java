package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/counting-bits/">338. Counting Bits</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution191
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.EASY
)
public class Solution338 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}