package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-and-replace-in-string/">833. Find And Replace in String</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution833 {

    @Complexity(time = "O(n+kL)", space = "O(n+kL)", note = "L is the average length of strings in sources and targets")
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length;
        Map<Integer, Integer> replaced = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int j = indices[i];
            if (s.startsWith(sources[i], j)) {
                replaced.put(j, i);
            }
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            Integer j = replaced.get(i);
            if (j == null) { // no replacement
                sb.append(s.charAt(i));
                i++;
            } else { // replacement
                sb.append(targets[j]);
                i += sources[j].length();
            }
        }
        return sb.toString();
    }
}