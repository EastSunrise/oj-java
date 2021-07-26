package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 409. Longest Palindrome (Easy)
 *
 * @author Kingen
 * @see Solution266
 * @see <a href="https://leetcode-cn.com/problems/longest-palindrome/">Longest Palindrome</a>
 * @since 2021-07-14
 */
public class Solution409 implements Solution {

    /**
     * @complexity T=O(n+58), 58='z'-'A'+1
     * @complexity S=O(58)
     */
    public int longestPalindrome(String s) {
        boolean[] single = new boolean[58];
        for (char ch : s.toCharArray()) {
            single[ch - 'A'] = !single[ch - 'A'];
        }
        int singles = 0;
        for (boolean flag : single) {
            if (flag) {
                singles++;
            }
        }
        return s.length() - singles + (singles > 0 ? 1 : 0);
    }
}
