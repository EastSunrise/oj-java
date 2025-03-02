package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning-ii/">132. Palindrome Partitioning II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution131
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1745
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2472
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2518

 */
@Question(
    tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.HARD,
    date = "2025-03-02"
)
public class Solution132 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public int minCut(String s) {
        int n = s.length();
        boolean[][] flags = new boolean[n][n + 1];
        for (int i = 0; i < n; i++) {
            flags[i][i] = flags[i][i + 1] = true;
        }
        char[] chars = s.toCharArray();
        for (int l = 2; l <= n; l++) {
            for (int i = n - l, j = n; i >= 0; i--, j--) {
                flags[i][j] = chars[i] == chars[j - 1] && flags[i + 1][j - 1];
            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (flags[0][i + 1]) {
                dp[i] = 0;
                continue;
            }

            dp[i] = i;
            for (int j = i; j > 0; j--) { // s[j,i] as a substring
                if (flags[j][i + 1]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}