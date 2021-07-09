package wsg.oj.java.leetcode.problems.p400;

import java.util.Arrays;
import java.util.Comparator;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 452. Minimum Number of Arrows to Burst Balloons (Medium)
 *
 * @author Kingen
 * @see Solution253
 * @see Solution435
 * @see <a href="https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/">Minimum
 * Number of Arrows to Burst Balloons</a>
 * @since 2021-07-08
 */
class Solution452 implements Solution {

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
