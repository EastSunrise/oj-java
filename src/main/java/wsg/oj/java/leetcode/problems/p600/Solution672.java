package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution319;

/**
 * 672. Bulb Switcher II (MEDIUM)
 *
 * @author Kingen
 * @see Solution319
 * @see Solution1375
 * @see <a href="https://leetcode-cn.com/problems/bulb-switcher-ii/">Bulb Switcher II</a>
 * @since 2021-07-23
 */
public class Solution672 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n > 3) {
            n = 3;
        }
        if (presses > 3) {
            presses = 3;
        }
        if (presses == 1) {
            return n == 2 ? 3 : 4;
        }
        if (presses == 2) {
            return n == 2 ? 4 : 7;
        }
        return n == 2 ? 4 : 8;
    }
}
