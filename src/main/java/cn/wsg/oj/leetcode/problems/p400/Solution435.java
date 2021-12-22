package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals (Medium)
 *
 * @author Kingen
 * @see Solution452
 * @see <a href="https://leetcode-cn.com/problems/non-overlapping-intervals/">Non-overlapping
 * Intervals</a>
 */
class Solution435 implements Solution {

    /**
     * Sorts the array, traverses from left to right and removes the interval with larger right
     * bound if overlapping.
     *
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparing(arr -> arr[0]));
        int right = intervals[0][1], count = 0;
        for (int i = 1; i < n; i++) {
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
