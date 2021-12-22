package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p700.Solution792;

/**
 * 392. Is Subsequence (Easy)
 *
 * @author Kingen
 * @see Solution792
 * @see Solution1055
 * @see <a href="https://leetcode-cn.com/problems/is-subsequence/">Is Subsequence</a>
 */
public class Solution392 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_CONSTANT
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
