package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1000.Solution1004;

/**
 * 424. Longest Repeating Character Replacement (Medium)
 *
 * @author Kingen
 * @see Solution340
 * @see Solution1004
 * @see <a href="https://leetcode-cn.com/problems/longest-repeating-character-replacement/">Longest
 * Repeating Character Replacement</a>
 */
public class Solution424 implements Solution {

    /**
     * Slides a window where the count of other numbers (except the most one) is never larger than
     * k.
     *
     * @complexity T=O(n)
     * @complexity S=O(26)
     */
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
