package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 521. Longest Uncommon Subsequence I (EASY)
 *
 * @author Kingen
 * @see Solution522
 * @see <a href="https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/">Longest Uncommon
 * Subsequence I</a>
 * @since 2021-07-20
 */
class Solution521 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
