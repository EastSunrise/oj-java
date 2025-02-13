package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.SameAs;
import cn.kingen.oj.leetcode.support.Tag;

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
        date = "2025-01-02"
)
public class MyCalendar {

    @SameAs(value = MyCalendarTwo.class, note = "MAX is 1")
    public MyCalendar() {
    }
}