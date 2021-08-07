package wsg.oj.java.leetcode.problems.p500;

import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p700.Solution720;

/**
 * 524. Longest Word in Dictionary through Deleting (MEDIUM)
 *
 * @author Kingen
 * @see Solution720
 * @see <a href="https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/">Longest
 * Word in Dictionary through Deleting</a>
 * @since 2021-07-20
 */
public class Solution524 extends Solution522 implements Solution {

    /**
     * @complexity T=O(L), L=total length of words in the dictionary
     * @complexity S=O(n), n=the length of s
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String w : dictionary) {
            if (isSubsequence(w, s)) {
                if (w.length() > res.length()
                    || (w.length() == res.length() && w.compareTo(res) < 0)) {
                    res = w;
                }
            }
        }
        return res;
    }
}
