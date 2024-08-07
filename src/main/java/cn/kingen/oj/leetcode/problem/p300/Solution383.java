package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/ransom-note/">383. Ransom Note</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution691
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.EASY
)
public class Solution383 {

    @Complexity(time = "O(m+n)", space = "O(C)", note = "C is the number of distinct characters")
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char ch : magazine.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (counts[ch - 'a'] == 0) {
                return false;
            } else {
                counts[ch - 'a']--;
            }
        }
        return true;
    }
}