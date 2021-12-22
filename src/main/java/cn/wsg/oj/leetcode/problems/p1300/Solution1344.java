package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1344. Angle Between Hands of a Clock (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/angle-between-hands-of-a-clock/">Angle Between
 * Hands of a Clock</a>
 */
public class Solution1344 implements Solution {

    /**
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     */
    public double angleClock(int hour, int minutes) {
        double res = Math.abs(hour % 12 * 30 + minutes / 2.0 - minutes * 6);
        return res <= 180 ? res : 360 - res;
    }
}
