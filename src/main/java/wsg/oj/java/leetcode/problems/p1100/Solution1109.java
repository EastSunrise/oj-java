package wsg.oj.java.leetcode.problems.p1100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1109. Corporate Flight Bookings (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/corporate-flight-bookings/">Corporate Flight
 * Bookings</a>
 * @since 2021-07-27
 */
public class Solution1109 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // differences[i] = answer[i] - answer[i-1]
        int[] differences = new int[n];
        for (int[] booking : bookings) {
            differences[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                differences[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            differences[i] += differences[i - 1];
        }
        return differences;
    }
}
