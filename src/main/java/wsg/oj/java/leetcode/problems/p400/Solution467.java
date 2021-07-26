package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 467. Unique Substrings in Wraparound String (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string/">Unique
 * Substrings in Wraparound String</a>
 * @since 2021-07-09
 */
public class Solution467 implements Solution {

    /**
     * @complexity T=O(n)
     * @complexity S=O(26)
     */
    public int findSubstringInWraproundString(String p) {
        int start = 0, n = p.length();
        // len[i]: the maximum length of the substrings of p
        // which start with i+'a' and are present in s.
        int[] lens = new int[26];
        while (start < n) {
            // find a substring of consecutive characters
            int end = start + 1;
            while (end < n && (p.charAt(end) - p.charAt(end - 1) + 26) % 26 == 1) {
                end++;
            }
            for (int i = start; i < end; i++) {
                int idx = p.charAt(i) - 'a';
                lens[idx] = Math.max(lens[idx], end - i);
            }
            start = end;
        }
        int count = 0;
        for (int len : lens) {
            count += len;
        }
        return count;
    }
}
