package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 522. Longest Uncommon Subsequence II (MEDIUM)
 *
 * @author Kingen
 * @see Solution521
 * @see <a href="https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii/">Longest Uncommon
 * Subsequence II</a>
 */
class Solution522 implements Solution {

    /**
     * @complexity T=O(l*n^2), l=the average length of strings
     * @complexity S=O(n)
     */
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        Map<String, Integer> counts = new HashMap<>(16);
        for (String str : strs) {
            counts.put(str, counts.getOrDefault(str, 0) + 1);
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        Set<String> visited = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (counts.get(strs[i]) == 1 && noneMatch(strs[i], visited)) {
                // a unique string
                return strs[i].length();
            }
            visited.add(strs[i]);
        }
        return -1;
    }

    private boolean noneMatch(String seq, Set<String> strs) {
        for (String str : strs) {
            if (isSubsequence(seq, str)) {
                return false;
            }
        }
        return true;
    }

    protected boolean isSubsequence(String seq, String str) {
        int n = seq.length();
        int dif = str.length() - n;
        if (dif < 0) {
            return false;
        }
        if (dif == 0) {
            return seq.equals(str);
        }
        int i = 0, j = 0;
        while (i < n && j <= dif + i) {
            if (seq.charAt(i) == str.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
