package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/meeting-rooms-ii/">253. Meeting Rooms II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution56
 * @see cn.kingen.oj.leetcode.problem.p200.Solution252
 * @see cn.kingen.oj.leetcode.problem.p400.Solution452
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1094
 */
@Question(
        paidOnly = true,
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.TWO_POINTERS, Tag.PREFIX_SUM, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution253 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // end times of rooms
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!rooms.isEmpty() && rooms.peek() <= interval[0]) {
                rooms.poll();
            }
            rooms.offer(interval[1]);
        }
        return rooms.size();
    }
}