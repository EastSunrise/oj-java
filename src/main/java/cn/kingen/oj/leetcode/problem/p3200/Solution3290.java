package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-multiplication-score/">3290. Maximum Multiplication Score</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM,
        contest = 415
)
public class Solution3290 {

    @Complexity(time = "O(mn)", space = "O(m)")
    public long maxScore(int[] a, int[] b) {
        int m = a.length, n = b.length;
        long[] dp = new long[m + 1];
        Arrays.fill(dp, Long.MIN_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + (long) a[j - 1] * b[i - 1]);
            }
        }
        return dp[m];
    }
}