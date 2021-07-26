package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 395. Longest Substring with At Least K Repeating Characters (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/">Longest
 * Substring with At Least K Repeating Characters</a>
 * @since 2021-07-06
 */
public class Solution395 implements Solution {

    /**
     * @complexity T=O(26*n)
     * @complexity S=O(26*26)
     * @see #DIVIDE_AND_CONQUER
     */
    public int longestSubstring(String s, int k) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] < k) {
                ch = (char) (i + 'a');
                break;
            }
        }
        if (ch == 0) {
            return s.length();
        }
        int res = 0, fromIdx = 0;
        while (true) {
            int i = s.indexOf(ch, fromIdx);
            if (i >= 0) {
                // a substring between the chars
                if (i > fromIdx) {
                    res = Math.max(res, longestSubstring(s.substring(fromIdx, i), k));
                }
                fromIdx = i + 1;
            } else {
                // last substring
                if (fromIdx < s.length()) {
                    res = Math.max(res, longestSubstring(s.substring(fromIdx), k));
                }
                break;
            }
        }
        return res;
    }
}
