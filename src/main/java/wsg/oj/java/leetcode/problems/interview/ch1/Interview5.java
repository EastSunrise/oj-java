package wsg.oj.java.leetcode.problems.interview.ch1;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 面试题 1.5. One Away LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/one-away-lcci/">One Away LCCI</a>
 * @since 2021-07-28
 */
public class Interview5 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int i = 0, j = 0;
        while (i < m && j < n && first.charAt(i) == second.charAt(j)) {
            i++;
            j++;
        }
        if (i == m || j == n) {
            return true;
        }
        return equals(first, i + 1, m, second, j, n)
            || equals(first, i, m, second, j + 1, n)
            || equals(first, i + 1, m, second, j + 1, n);
    }

    private boolean equals(String s1, int fromIn1, int toEx1, String s2, int fromIn2, int toEx2) {
        if (toEx1 - fromIn1 != toEx2 - fromIn2) {
            return false;
        }
        while (fromIn1 < toEx1 && s1.charAt(fromIn1) == s2.charAt(fromIn2)) {
            fromIn1++;
            fromIn2++;
        }
        return fromIn1 == toEx1;
    }
}
