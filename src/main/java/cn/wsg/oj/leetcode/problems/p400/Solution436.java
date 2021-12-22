package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution352;
import java.util.Map;
import java.util.TreeMap;

/**
 * 436. Find Right Interval (Medium)
 *
 * @author Kingen
 * @see Solution352
 * @see <a href="https://leetcode-cn.com/problems/find-right-interval/">Find Right Interval</a>
 */
public class Solution436 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_N
     */
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            starts.put(intervals[i][0], i);
        }
        int[] indices = new int[len];
        for (int i = 0; i < len; i++) {
            int[] interval = intervals[i];
            Map.Entry<Integer, Integer> entry = starts.ceilingEntry(interval[1]);
            indices[i] = entry == null ? -1 : entry.getValue();
        }
        return indices;
    }
}
