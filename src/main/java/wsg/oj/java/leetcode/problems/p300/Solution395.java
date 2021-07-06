package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.Solution;

/**
 * 395. Longest Substring with At Least K Repeating Characters (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/">Longest
 * Substring with At Least K Repeating Characters</a>
 * @since 2021-07-06
 */
class Solution395 extends Solution {

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
        int res = 0, fromIndex = 0;
        while (true) {
            int i = s.indexOf(ch, fromIndex);
            if (i >= 0) {
                // a substring between the chars
                if (i > fromIndex) {
                    res = Math.max(res, longestSubstring(s.substring(fromIndex, i), k));
                }
                fromIndex = i + 1;
            } else {
                // last substring
                if (fromIndex < s.length()) {
                    res = Math.max(res, longestSubstring(s.substring(fromIndex), k));
                }
                break;
            }
        }
        return res;
    }
}
