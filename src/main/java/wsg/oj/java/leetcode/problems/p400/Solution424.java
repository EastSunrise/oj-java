package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 424. Longest Repeating Character Replacement (Medium)
 *
 * @author Kingen
 * @see Solution340
 * @see Solution1004
 * @see <a href="https://leetcode-cn.com/problems/longest-repeating-character-replacement/">Longest
 * Repeating Character Replacement</a>
 * @since 2021-07-07
 */
class Solution424 implements Solution {

    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0, maxCount = 0, len = s.length();
        for (int right = 0; right < len; right++) {
            int ci = s.charAt(right) - 'A';
            counts[ci]++;
            maxCount = Math.max(maxCount, counts[ci]);
            if (right - left + 1 - maxCount > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return len - left;
    }
}
