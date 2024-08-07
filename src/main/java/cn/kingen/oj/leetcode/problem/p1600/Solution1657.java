package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/determine-if-two-strings-are-close/">1657. Determine if Two Strings Are Close</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution859
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1247
 * @see cn.kingen.oj.leetcode.problem.p1300.Solution1347
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution1657 {

    @Complexity(time = "O(max{n1,n2}+C*log{C})", space = "O(C)", note = "C is the number of distinct characters")
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] counts1 = new int[26], counts2 = new int[26];
        for (char ch : word1.toCharArray()) {
            counts1[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            counts2[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((counts1[i] == 0) ^ (counts2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(counts1);
        Arrays.sort(counts2);
        return Arrays.equals(counts1, counts2);
    }
}