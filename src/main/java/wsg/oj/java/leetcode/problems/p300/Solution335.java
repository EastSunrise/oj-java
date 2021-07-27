package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 335. Self Crossing (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/self-crossing/">Self Crossing</a>
 * @since 2021-07-27
 */
public class Solution335 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isSelfCrossing(int[] x) {
        int n = x.length;
        for (int i = 3; i < n; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            }
        }
        for (int i = 4; i < n; i++) {
            if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                return true;
            }
        }
        for (int i = 5; i < n; i++) {
            if (x[i - 3] > x[i - 1] && x[i - 2] > x[i - 4]) {
                if (x[i - 1] + x[i - 5] >= x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                    return true;
                }
            }
        }
        return false;
    }
}
