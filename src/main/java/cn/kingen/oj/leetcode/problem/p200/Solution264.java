package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-ii/">264. Ugly Number II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution23
 * @see cn.kingen.oj.leetcode.problem.p200.Solution204
 * @see cn.kingen.oj.leetcode.problem.p200.Solution263
 * @see cn.kingen.oj.leetcode.problem.p200.Solution279
 * @see cn.kingen.oj.leetcode.problem.p300.Solution313
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution264 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = 2 * dp[p2], num3 = 3 * dp[p3], num5 = 5 * dp[p5];
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}