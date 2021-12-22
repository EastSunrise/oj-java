package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution228;
import cn.wsg.oj.leetcode.problems.p400.Solution436;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 352. Data Stream as Disjoint Intervals (HARD)
 *
 * @author Kingen
 * @see Solution228
 * @see Solution436
 * @see Solution715
 * @see <a href="https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/">Data Stream as
 * Disjoint Intervals</a>
 */
public class Solution352 implements Solution {

    static class SummaryRanges {

        private final List<Integer> starts;
        private final List<Integer> ends;

        public SummaryRanges() {
            this.starts = new ArrayList<>();
            this.ends = new ArrayList<>();
            starts.add(Integer.MIN_VALUE);
            ends.add(Integer.MIN_VALUE);
            starts.add(Integer.MAX_VALUE);
            ends.add(Integer.MAX_VALUE);
        }

        public void addNum(int val) {
            int i = Collections.binarySearch(starts, val);
            if (i >= 0) {
                // overlapping
                return;
            }
            i = -(i + 1);
            int prevEnd = ends.get(i - 1);
            if (val <= prevEnd) {
                // overlapping with the previous interval
                return;
            }
            int nextStart = starts.get(i);
            if (val >= nextStart) {
                // overlapping with the next interval
                return;
            }
            if (val > prevEnd + 1) {
                if (val < nextStart - 1) {
                    // add a new interval
                    starts.add(i, val);
                    ends.add(i, val);
                } else {
                    // merge with the next interval
                    starts.set(i, val);
                }
            } else {
                if (val < nextStart - 1) {
                    // merge with the previous interval
                    ends.set(i - 1, val);
                } else {
                    // merge the previous, this and next intervals
                    starts.remove(i);
                    ends.set(i - 1, ends.remove(i));
                }
            }
        }

        public int[][] getIntervals() {
            int n = starts.size() - 2;
            int[][] intervals = new int[n][];
            for (int i = 0; i < n; i++) {
                intervals[i] = new int[]{starts.get(i + 1), ends.get(i + 1)};
            }
            return intervals;
        }
    }
}
