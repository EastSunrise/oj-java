package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-word-in-dictionary/">720. Longest Word in Dictionary</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution524
 * @see cn.kingen.oj.leetcode.problem.p600.MagicDictionary
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1858
 */
@Question(
        tags = {Tag.TRIE, Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution720 {

    @Complexity(time = "O(nlog{n})", space = "O(n)")
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> prefixes = new HashSet<>();
        prefixes.add("");
        String ans = "";
        for (String word : words) {
            if (prefixes.contains(word.substring(0, word.length() - 1))) {
                if (word.length() > ans.length()) {
                    ans = word;
                }
                prefixes.add(word);
            }
        }
        return ans;
    }
}