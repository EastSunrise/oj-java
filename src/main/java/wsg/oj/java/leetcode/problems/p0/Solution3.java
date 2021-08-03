package wsg.oj.java.leetcode.problems.p0;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 3. Longest Substring Without Repeating Characters (Medium)
 *
 * @author Kingen
 * @see Solution159
 * @see Solution340
 * @see Solution992
 * @see Solution1695
 * @see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">Longest
 * Substring Without Repeating Characters</a>
 * @since 2021-07-10
 */
public class Solution3 implements Solution {

    /**
     * Slides a window and records the indices of chars with a map.
     *
     * @complexity S=O(L), L=len(set(chars))
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int start = 0, max = 0;
        Map<Character, Integer> indices = new HashMap<>(64);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            Integer idx = indices.get(ch);
            if (idx != null) {
                if (idx >= start) {
                    max = Math.max(max, i - start);
                    start = idx + 1;
                }
            }
            indices.put(ch, i);
        }
        max = Math.max(max, n - start);
        return max;
    }
}
