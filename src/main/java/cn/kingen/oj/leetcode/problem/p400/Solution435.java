package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/non-overlapping-intervals/">435. Non-overlapping Intervals</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution452

 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution435 {

    @Complexity(time = "O(n*log(n))", space = "O(1)")
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparing(arr -> arr[0]));
        int right = intervals[0][1], count = 0;
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] < right) {
                count++;
                right = Math.min(right, interval[1]);
            } else {
                right = interval[1];
            }
        }
        return count;
    }
}