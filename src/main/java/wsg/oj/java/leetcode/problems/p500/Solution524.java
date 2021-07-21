package wsg.oj.java.leetcode.problems.p500;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * todo 524. Longest Word in Dictionary through Deleting (MEDIUM)
 *
 * @author Kingen
 * @see Solution720
 * @see <a href="https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/">Longest
 * Word in Dictionary through Deleting</a>
 * @since 2021-07-20
 */
class Solution524 extends Solution522 implements Solution {

    public String findLongestWord(String s, String[] dictionary) {
        Arrays.sort(dictionary, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s2.length() - s1.length();
        });
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                return word;
            }
        }
        return "";
    }
}
