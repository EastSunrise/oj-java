package wsg.oj.java.leetcode.problems.p400;

import java.util.Arrays;
import java.util.Comparator;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 435. Non-overlapping Intervals (Medium)
 *
 * @author Kingen
 * @see Solution452
 * @see <a href="https://leetcode-cn.com/problems/non-overlapping-intervals/">Non-overlapping
 * Intervals</a>
 * @since 2021-07-07
 */
class Solution435 implements Solution {

    /**
     * Sorts the array, traverses from left to right and removes the interval with larger right
     * bound if overlapping.
     *
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(arr -> arr[0]));
        int right = intervals[0][1], count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < right) {
                count++;
                right = Math.min(right, interval[1]);
            } else {
                right = interval[1];
            }
        }
        return count;
    }
}
