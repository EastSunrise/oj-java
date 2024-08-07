package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/extra-characters-in-a-string/">2707. Extra Characters in a String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution139
 */
@Question(
        tags = {Tag.TRIE, Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2707 {

    @Complexity(time = "O(n^3)+ml", space = "O(n+ml)")
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        // dp[j]: the optimal of s.substring(0,j)
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] + 1;
            for (int i = 0; i < j; i++) {
                // 分割为s[0:i]和s[i:j]
                if (set.contains(s.substring(i, j))) {
                    dp[j] = Math.min(dp[j], dp[i]);
                }
            }
        }
        return dp[n];
    }
}