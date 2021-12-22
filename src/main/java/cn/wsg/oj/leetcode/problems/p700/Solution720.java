package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p500.Solution524;
import cn.wsg.oj.leetcode.problems.p600.Solution676;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 720. Longest Word in Dictionary (EASY)
 *
 * @author Kingen
 * @see Solution524
 * @see Solution676
 * @see Solution1858
 * @see <a href="https://leetcode-cn.com/problems/longest-word-in-dictionary/">Longest Word in
 * Dictionary</a>
 */
public class Solution720 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_N
     */
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> prefixes = new HashSet<>();
        prefixes.add("");
        String res = "";
        for (String word : words) {
            if (prefixes.contains(word.substring(0, word.length() - 1))) {
                if (word.length() > res.length()) {
                    res = word;
                }
                prefixes.add(word);
            }
        }
        return res;
    }
}
