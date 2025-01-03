package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/my-calendar-ii/">731. My Calendar II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.MyCalendar
 * @see cn.kingen.oj.leetcode.problem.p700.MyCalendarThree
 */
@Question(
        tags = {Tag.DESIGN, Tag.SEGMENT_TREE, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.ORDERED_SET, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM,
        daily = "2025-01-03"
)
public class MyCalendarTwo {

    private static final int MAX = 2;

    // time point and count
    private final TreeMap<Integer, Integer> points;

    public MyCalendarTwo() {
        this.points = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Map.Entry<Integer, Integer> prev = points.floorEntry(startTime);
        if (prev != null && prev.getValue() == MAX) {
            return false;
        }
        NavigableMap<Integer, Integer> middle = points.subMap(startTime, false, endTime, false);
        for (int cnt : middle.values()) {
            if (cnt == MAX) {
                return false;
            }
        }
        Map.Entry<Integer, Integer> last = points.floorEntry(endTime);

        points.put(startTime, prev == null ? 1 : prev.getValue() + 1);
        middle.replaceAll((k, v) -> v + 1);
        points.put(endTime, last == null ? 0 : last.getValue());
        return true;
    }
}