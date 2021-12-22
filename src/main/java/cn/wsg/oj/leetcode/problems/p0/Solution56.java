package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution495;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
 */
public class Solution56 implements Solution {

    /**
     * Sorts the array by start and then merge it.
     *
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_N
     */
    public int[][] merge(int[][] intervals) {
        // sort by start times
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            // merge if overlapping
            if (cur[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                res.add(cur);
                prev = cur;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
