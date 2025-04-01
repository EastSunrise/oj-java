package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/solving-questions-with-brainpower/">2140. Solving Questions With
 * Brainpower</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution198
 * @see cn.kingen.oj.leetcode.problem.p400.Solution403
 */
@Question(
    tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.MEDIUM,
    date = "2025-04-01"
)
public class Solution2140 {

    @Complexity(time = "O(n)", space = "O(n)")
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[Math.min(n, i + questions[i][1] + 1)]);
        }
        return dp[0];
    }
}