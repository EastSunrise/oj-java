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
public class Solution392 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) {
            return false;
        }
        int si = 0, ti = 0;
        while (si < m && ti < n) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }
            ti++;
        }
        return si == m;
    }
}
