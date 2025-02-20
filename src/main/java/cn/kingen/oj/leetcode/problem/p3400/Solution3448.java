package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/count-substrings-divisible-by-last-digit/">3448. Count Substrings Divisible By Last Digit</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2950

 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD,
        contest = 436
)
public class Solution3448 {

    @Complexity(time = "O(n*k*k)", space = "O(k*k)", note = "k is 10")
    public long countSubstrings(String s) {
        int n = s.length();
        long ans = 0;
        long[][] dp = new long[10][9], next = new long[10][9], tmp;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            for (int p = 1; p < 10; p++) {
                Arrays.fill(next[p], 0);
                next[p][d % p] = 1;
                for (int r = 0; r < p; r++) {
                    next[p][(r * 10 + d) % p] += dp[p][r];
                }
            }
            tmp = dp;
            dp = next;
            next = tmp;
            ans += dp[d][0];
        }
        return ans;
    }

}