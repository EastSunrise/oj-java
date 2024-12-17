package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.*;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.TrieUtils.insertWord;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-valid-strings-to-form-target-i/">3291. Minimum Number of Valid Strings to Form Target I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2977
 * @see cn.kingen.oj.leetcode.problem.p3200.Solution3213
 */
@Question(
        tags = {Tag.TRIE, Tag.SEGMENT_TREE, Tag.ARRAY, Tag.STRING, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.STRING_MATCHING, Tag.HASH_FUNCTION, Tag.ROLLING_HASH},
        difficulty = Difficulty.MEDIUM
)
public class Solution3291 {

    @Complexity(time = "O(#)", space = "O(#)")
    public int minValidStrings(String[] words, String target) {
        int m = target.length();
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertWord(root, word);
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, 0x7ffffff);
        dp[m] = 0;
        for (int i = m - 1; i >= 0; i--) {
            TrieNode t = root;
            for (int j = i; j < m; j++) { // dp[i] = min(dp[j+1]+1, dp[i])
                int ch = target.charAt(j) - 'a';
                if ((t = t.next[ch]) == null) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j + 1] + 1);
            }
        }
        return dp[0] >= 0x7ffffff ? -1 : dp[0];
    }
}