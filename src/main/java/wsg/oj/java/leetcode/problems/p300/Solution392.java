package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 392. Is Subsequence (Easy)
 *
 * @author Kingen
 * @see Solution792
 * @see Solution1055
 * @see <a href="https://leetcode-cn.com/problems/is-subsequence/">Is Subsequence</a>
 * @since 2021-07-13
 */
class Solution392 implements Solution {

    /**
     * @complexity T=O(l), l=len(t)
     * @complexity S=O(1)
     */
    public boolean isSubsequence(String s, String t) {
        int si = s.length() - 1, ti = t.length() - 1;
        if (si > ti) {
            return false;
        }
        while (si >= 0 && ti >= 0) {
            if (s.charAt(si) == t.charAt(ti)) {
                si--;
            }
            ti--;
        }
        return si < 0;
    }
}
