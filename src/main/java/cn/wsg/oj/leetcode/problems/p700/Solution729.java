package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 729. My Calendar I (MEDIUM)
 *
 * @author Kingen
 * @see Solution731
 * @see Solution732
 * @see <a href="https://leetcode-cn.com/problems/my-calendar-i/">My Calendar I</a>
 */
public class Solution729 implements Solution {

    static class MyCalendar {

        private final List<Integer> starts;
        private final List<Integer> ends;

        public MyCalendar() {
            this.starts = new ArrayList<>();
            this.ends = new ArrayList<>();
            starts.add(Integer.MIN_VALUE);
            ends.add(Integer.MIN_VALUE);
            starts.add(Integer.MAX_VALUE);
            ends.add(Integer.MAX_VALUE);
        }

        public boolean book(int start, int end) {
            int i = Collections.binarySearch(starts, start);
            if (i >= 0) {
                // overlapping
                return false;
            }
            i = -(i + 1);
            int prevEnd = ends.get(i - 1);
            if (start < prevEnd) {
                // overlapping with the previous interval
                return false;
            }
            int nextStart = starts.get(i);
            if (end > nextStart) {
                // overlapping with the next interval
                return false;
            }
            if (start > prevEnd) {
                if (end < nextStart) {
                    // add a new interval
                    starts.add(i, start);
                    ends.add(i, end);
                } else {
                    // merge with the next interval
                    starts.set(i, start);
                }
            } else {
                if (end < nextStart) {
                    // merge with the previous interval
                    ends.set(i - 1, end);
                } else {
                    // merge the previous, this and next intervals
                    starts.remove(i);
                    ends.set(i - 1, ends.remove(i));
                }
            }
            return true;
        }
    }
}
