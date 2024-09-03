package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/new-21-game/">837. New 21 Game</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.SLIDING_WINDOW, Tag.PROBABILITY_AND_STATISTICS},
        difficulty = Difficulty.MEDIUM
)
public class Solution837 {

    @Complexity(time = "O(k+m)", space = "O(k+m)")
    public double new21Game(int n, int k, int maxPts) {
        if (k - 1 + maxPts <= n) {
            return 1.0;
        }
        double[] dp = new double[k + maxPts];
        Arrays.fill(dp, k, n + 1, 1.0);
        double sum = n - k + 1;
        for (int i = k - 1; i >= 0; i--) {
            dp[i] = sum / maxPts;
            sum += dp[i] - dp[i + maxPts];
        }
        return dp[0];
    }
}