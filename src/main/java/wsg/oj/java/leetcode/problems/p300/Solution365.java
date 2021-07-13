package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 365. Water and Jug Problem (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/water-and-jug-problem/">Water and Jug Problem</a>
 * @since 2021-07-04
 */
class Solution365 implements Solution {

    /**
     * The integer solutions of the equation ax+by=c. The equation has integer solutions if and only
     * if gcd(a,b)|c.
     *
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }
}
