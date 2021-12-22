package cn.wsg.oj.leetcode.problems.p1700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p800.Solution859;

/**
 * 1790. Check if One String Swap Can Make Strings Equal (EASY)
 *
 * @author Kingen
 * @see Solution859
 * @see <a href="https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal/">Check
 * if One String Swap Can Make Strings Equal</a>
 */
public class Solution1790 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int i = -1, j = -1;
        for (int k = 0; k < n; k++) {
            if (s1.charAt(k) != s2.charAt(k)) {
                if (i == -1) {
                    i = k;
                } else if (j == -1) {
                    j = k;
                } else {
                    return false;
                }
            }
        }
        if (i == -1) {
            return true;
        }
        if (j == -1) {
            return false;
        }
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}
