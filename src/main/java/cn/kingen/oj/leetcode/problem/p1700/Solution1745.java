package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning-iv/">1745. Palindrome Partitioning IV</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution131
 * @see cn.kingen.oj.leetcode.problem.p100.Solution132
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1278
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2472

 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution1745 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public boolean checkPartitioning(String s) {
        int n = s.length();
        // flags[i][j]: whether s[i,j-1] is a palindrome
        boolean[][] flags = new boolean[n][n + 1];
        for (int i = 0; i < n; i++) {
            flags[i][i] = flags[i][i + 1] = true;
        }
        char[] chars = s.toCharArray();
        for (int l = 2; l <= n; l++) {
            for (int i = n - l, j = n; i >= 0; i--, j--) {
                flags[i][j] = flags[i + 1][j - 1] && chars[i] == chars[j - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (flags[0][i] && flags[i][j] && flags[j][n]) {
                    return true;
                }
            }
        }
        return false;
    }
}