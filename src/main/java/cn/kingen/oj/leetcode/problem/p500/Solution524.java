package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

import static cn.kingen.oj.leetcode.util.StringUtils.isSubsequence;

/**
 * <a href="https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/">524. Longest Word in Dictionary through Deleting</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution720
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution524 {

    @Complexity(time = "O(n*L)", space = "O(1)", note = "n is the size of dictionary and L is the average length of strings in dictionary")
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String w : dictionary) {
            if (isSubsequence(w, s)) {
                if (w.length() > ans.length() || (w.length() == ans.length() && w.compareTo(ans) < 0)) {
                    ans = w;
                }
            }
        }
        return ans;
    }
}