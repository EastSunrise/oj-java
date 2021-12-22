package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 14. Longest Common Prefix (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 */
public class Solution14 implements Solution {

    /**
     * Compares the characters one by one.
     *
     * @complexity T=O(nL), L=len(longest common prefix)
     * @see Complexity#SPACE_CONSTANT
     */
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(min, str.length());
        }
        for (int i = 0; i < min; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (ch != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, min);
    }

    /**
     * Sorts the array and compares the first string and the last string.
     *
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public String longestCommonPrefix2(String[] strs) {
        int n = strs.length;
        if (n == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0, max = Math.min(first.length(), last.length());
        while (i < max && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
    }
}
