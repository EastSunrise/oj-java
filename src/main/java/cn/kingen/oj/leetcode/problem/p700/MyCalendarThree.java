package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/my-calendar-iii/">732. My Calendar III</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.MyCalendar
 * @see cn.kingen.oj.leetcode.problem.p700.MyCalendarTwo
 * @see cn.kingen.oj.leetcode.problem.p2200.CountIntervals
 */
@Question(
    tags = {Tag.DESIGN, Tag.SEGMENT_TREE, Tag.BINARY_SEARCH, Tag.ORDERED_SET, Tag.PREFIX_SUM},
    difficulty = Difficulty.HARD,
    daily = "2025-01-04"
)
public class MyCalendarThree {

    // time point and count
    private final TreeMap<Integer, Integer> points;
    private int max = 0;

    public MyCalendarThree() {
        this.points = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        Map.Entry<Integer, Integer> prev = points.floorEntry(startTime);
        NavigableMap<Integer, Integer> middle = points.subMap(startTime, false, endTime, false);
        Map.Entry<Integer, Integer> last = points.floorEntry(endTime);

        int startCnt = prev == null ? 1 : prev.getValue() + 1;
        points.put(startTime, startCnt);
        points.put(endTime, last == null ? 0 : last.getValue());
        middle.replaceAll((k, v) -> {
            max = Math.max(max, v + 1);
            return v + 1;
        });
        return (max = Math.max(max, startCnt));
    }
}