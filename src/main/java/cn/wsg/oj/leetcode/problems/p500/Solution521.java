package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 521. Longest Uncommon Subsequence I (EASY)
 *
 * @author Kingen
 * @see Solution522
 * @see <a href="https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/">Longest Uncommon
 * Subsequence I</a>
 */
public class Solution521 implements Solution {

    /**
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
