package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/">131. Palindrome Partitioning</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution132
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1745
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2472

 */
@Question(
    tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING, Tag.BACKTRACKING},
    difficulty = Difficulty.MEDIUM,
    date = "2025-03-01"
)
public class Solution131 {

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = dp[i][i + 1] = true;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = n - l, j = n; i >= 0; i--, j--) {
                dp[i][j] = s.charAt(i) == s.charAt(j - 1) && dp[i + 1][j - 1];
            }
        }

        List<List<String>> ans = new ArrayList<>();
        dfs(ans, dp, s, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(List<List<String>> ans, boolean[][] dp, String s, int i, List<String> path) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            if (dp[i][j]) {
                path.add(s.substring(i, j));
                dfs(ans, dp, s, j, path);
                path.removeLast();
            }
        }
    }
}