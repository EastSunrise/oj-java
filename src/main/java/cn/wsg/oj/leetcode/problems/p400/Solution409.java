package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 409. Longest Palindrome (Easy)
 *
 * @author Kingen
 * @see Solution266
 * @see <a href="https://leetcode-cn.com/problems/longest-palindrome/">Longest Palindrome</a>
 */
public class Solution409 implements Solution {

    /**
     * @complexity T=O(n+58), 58='z'-'A'+1
     * @complexity S=O(58)
     */
    public int longestPalindrome(String s) {
        boolean[] chars = new boolean[58];
        int len = 0;
        for (char ch : s.toCharArray()) {
            if (chars[ch - 'A']) {
                len += 2;
                chars[ch - 'A'] = false;
            } else {
                chars[ch - 'A'] = true;
            }
        }
        return s.length() > len ? len + 1 : len;
    }
}
