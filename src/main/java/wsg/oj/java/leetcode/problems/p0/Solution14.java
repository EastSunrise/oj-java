package wsg.oj.java.leetcode.problems.p0;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 14. Longest Common Prefix (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 * @since 2021-07-10
 */
public class Solution14 implements Solution {

    /**
     * Compares the characters one by one.
     *
     * @complexity T=O(nL), L=len(longest common prefix)
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
