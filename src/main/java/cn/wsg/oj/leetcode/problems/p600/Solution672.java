package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution319;

/**
 * 672. Bulb Switcher II (MEDIUM)
 *
 * @author Kingen
 * @see Solution319
 * @see Solution1375
 * @see <a href="https://leetcode-cn.com/problems/bulb-switcher-ii/">Bulb Switcher II</a>
 */
public class Solution672 implements Solution {

    /**
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
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
