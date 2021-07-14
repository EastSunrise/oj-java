package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 56. Merge Intervals (Medium)
 *
 * @author Kingen
 * @see Solution57
 * @see Solution252
 * @see Solution253
 * @see Solution495
 * @see Solution616
 * @see Solution715
 * @see Solution759
 * @see Solution763
 * @see Solution986
 * @see <a href="https://leetcode-cn.com/problems/merge-intervals/">Merge Intervals</a>
 * @since 2021-07-11
 */
public class Solution56 implements Solution {

    /**
     * Sorts the array by start and then merge it.
     *
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[][] merge(int[][] intervals) {
        // sort by start times
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            // merge if overlapping
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                res.add(cur);
                last = cur;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
