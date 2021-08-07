package wsg.oj.java.leetcode.problems.p1300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1344. Angle Between Hands of a Clock (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/angle-between-hands-of-a-clock/">Angle Between
 * Hands of a Clock</a>
 * @since 2021-07-27
 */
public class Solution1344 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public double angleClock(int hour, int minutes) {
        double res = Math.abs(hour % 12 * 30 + minutes / 2.0 - minutes * 6);
        return res <= 180 ? res : 360 - res;
    }
}
