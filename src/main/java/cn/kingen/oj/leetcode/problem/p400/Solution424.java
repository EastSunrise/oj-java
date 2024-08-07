package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/longest-repeating-character-replacement/">424. Longest Repeating Character Replacement</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution340
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1004
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution424 {

    /**
     * Slides a window where the count of other numbers (except the most one) is never larger than k.
     */
    @Complexity(time = "O(n)", space = "O(C)", note = "C is the size of charset")
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0, maxCount = 0, n = s.length();
        for (int j = 0; j < n; j++) {
            int ch = s.charAt(j) - 'A';
            freq[ch]++;
            maxCount = Math.max(maxCount, freq[ch]);
            if (j - i + 1 - maxCount > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }
        }
        return n - i;
    }
}