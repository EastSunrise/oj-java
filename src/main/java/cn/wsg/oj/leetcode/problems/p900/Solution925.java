package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 925. Long Pressed Name (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/long-pressed-name/">Long Pressed Name</a>
 */
public class Solution925 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length(), m = typed.length();
        if (n > m) {
            return false;
        }
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        int ni = 1, ti = 1;
        while (ni < n && ti < m) {
            if (name.charAt(ni) == typed.charAt(ti)) {
                ni++;
                ti++;
            } else if (name.charAt(ni - 1) == typed.charAt(ti)) {
                ti++;
            } else {
                return false;
            }
        }
        if (ni < n) {
            return false;
        }
        char last = name.charAt(n - 1);
        while (ti < m) {
            if (typed.charAt(ti++) != last) {
                return false;
            }
        }
        return true;
    }
}
