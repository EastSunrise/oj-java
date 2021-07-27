package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 849. Maximize Distance to Closest Person (MEDIUM)
 *
 * @author Kingen
 * @see Solution855
 * @see <a href="https://leetcode-cn.com/problems/maximize-distance-to-closest-person/">Maximize
 * Distance to Closest Person</a>
 * @since 2021-07-26
 */
class Solution849 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxDistToClosest(int[] seats) {
        int i = 0, n = seats.length;
        while (i < n && seats[i] == 0) {
            i++;
        }
        int distance = i;
        while (true) {
            while (i < n && seats[i] == 1) {
                i++;
            }
            if (i == n) {
                return distance;
            }
            int start = i;
            while (i < n && seats[i] == 0) {
                i++;
            }
            if (i == n) {
                return Math.max(distance, i - start);
            }
            distance = Math.max(distance, (i - start + 1) / 2);
        }
    }
}
