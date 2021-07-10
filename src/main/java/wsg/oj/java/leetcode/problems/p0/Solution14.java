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
class Solution14 implements Solution {

    /**
     * Compares the characters one by one.
     *
     * @complexity T(n)=O(nL), L=len(longest common prefix)
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }
        String first = strs[0];
        for (int ci = 0; ci < first.length(); ci++) {
            char fch = first.charAt(ci);
            for (int si = 1; si < length; si++) {
                String str = strs[si];
                if (ci >= str.length()) {
                    return first.substring(0, ci);
                }
                char ch = str.charAt(ci);
                if (ch != fch) {
                    return first.substring(0, ci);
                }
            }
        }
        return first;
    }

    /**
     * Sorts the array and compares the first string and the last string.
     *
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public String longestCommonPrefix2(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int index = 0;
        while (index < first.length() && index < last.length() && first.charAt(index) == last
            .charAt(index)) {
            index++;
        }
        return first.substring(0, index);
    }
}
