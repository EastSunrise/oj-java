package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/">242. Valid Anagram</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution49
 * @see cn.kingen.oj.leetcode.problem.p200.Solution266
 * @see cn.kingen.oj.leetcode.problem.p400.Solution438
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution242 {

    @Complexity(time = "O(n)", space = "O(C)", note = "C is the size of charset")
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (count[ch - 'a'] == 0) {
                return false;
            }
            count[ch - 'a']--;
        }
        return true;
    }
}