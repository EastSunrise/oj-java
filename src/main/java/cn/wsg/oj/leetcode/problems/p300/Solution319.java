package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p600.Solution672;

/**
 * 319. Bulb Switcher (Medium)
 *
 * @author Kingen
 * @see Solution672
 * @see Solution995
 * @see Solution1375
 * @see <a href="https://leetcode-cn.com/problems/bulb-switcher/">Bulb Switcher</a>
 */
public class Solution319 implements Solution {

    /**
     * The number of switching ith bulb is represented as the count of factors of the number i
     * (including itself). The bulb will be on if and only if the count of factors is odd which
     * means the number i is a square. So find the count of squares within n.
     *
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
