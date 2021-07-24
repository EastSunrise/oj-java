package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution5;
import wsg.oj.java.leetcode.problems.p500.Solution516;

/**
 * 647. Palindromic Substrings (MEDIUM)
 *
 * @author Kingen
 * @see Solution5
 * @see Solution516
 * @see <a href="https://leetcode-cn.com/problems/palindromic-substrings/">Palindromic
 * Substrings</a>
 * @since 2021-07-23
 */
class Solution647 implements Solution {

    /**
     * todo Manacher Algorithm
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int countSubstrings(String s) {
        int n = s.length(), count = 0;
        for (int i = 0; i < n; i++) {
            int left = i, right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
