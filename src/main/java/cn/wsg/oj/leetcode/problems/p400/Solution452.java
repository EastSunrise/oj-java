package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons (Medium)
 *
 * @author Kingen
 * @see Solution253
 * @see Solution435
 * @see <a href="https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/">Minimum
 * Number of Arrows to Burst Balloons</a>
 */
public class Solution452 implements Solution {

    /**
     * Sorts the array, travers from left to right and picks the smaller right bound if
     * overlapping.
     *
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int end = points[0][1], count = 1;
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] > end) {
                // not overlapping
                end = point[1];
                count++;
            } else {
                // overlapping
                end = Math.min(end, point[1]);
            }
        }
        return count;
    }
}
