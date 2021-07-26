package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 57. Insert Interval (Medium)
 *
 * @author Kingen
 * @see Solution56
 * @see Solution715
 * @see <a href="https://leetcode-cn.com/problems/insert-interval/">Insert Interval</a>
 * @since 2021-07-11
 */
public class Solution57 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> res = new ArrayList<>(intervals.length);
        int i = 0;
        while (i < len) {
            int[] interval = intervals[i];
            if (newInterval[1] < interval[0]) {
                break;
            } else if (interval[1] < newInterval[0]) {
                res.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            i++;
        }
        res.add(newInterval);
        while (i < len) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[0][]);
    }
}
