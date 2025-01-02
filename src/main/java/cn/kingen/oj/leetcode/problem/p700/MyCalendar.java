package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/my-calendar-i/">729. My Calendar I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.MyCalendarTwo
 * @see cn.kingen.oj.leetcode.problem.p700.MyCalendarThree
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2446
 */
@Question(
        tags = {Tag.DESIGN, Tag.SEGMENT_TREE, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.ORDERED_SET},
        difficulty = Difficulty.MEDIUM,
        daily = "2025-01-02"
)
public class MyCalendar {

    // true: startTime, false: endTime
    private final TreeMap<Integer, Boolean> points;

    public MyCalendar() {
        this.points = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Map.Entry<Integer, Boolean> floor = points.floorEntry(startTime);
        if (floor != null && floor.getValue()) {
            return false;
        }
        Map.Entry<Integer, Boolean> next = floor == null ? points.firstEntry() : points.higherEntry(floor.getKey());
        if (next != null && endTime > next.getKey()) {
            return false;
        }
        points.put(startTime, true);
        if (!points.containsKey(endTime)) {
            points.put(endTime, false);
        }
        return true;
    }
}