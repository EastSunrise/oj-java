package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/">3297. Count Substrings That Can Be Rearranged to Contain a String I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution76

 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM,
        daily = "2025-01-09"
)
public class Solution3297 {

    @Complexity(time = "O(n+m)", space = "O(C)", note = "C is the number of distinct characters")
    public long validSubstringCount(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] count = new int[26], target = new int[26];
        for (int i = 0; i < m; i++) {
            target[word2.charAt(i) - 'a']++;
        }

        long ans = 0;
        int total = 0, ch;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && total < m) {
                count[ch = word1.charAt(j) - 'a']++;
                if (count[ch] <= target[ch]) {
                    total++;
                }
                j++;
            }
            if (total == m) {
                ans += n - j + 1;
            }
            count[ch = word1.charAt(i) - 'a']--;
            if (count[ch] < target[ch]) {
                total--;
            }
        }
        return ans;
    }
}