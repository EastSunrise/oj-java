package cn.kingen.oj.leetcode.problem.p1400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/">1450. Number of Students Doing Homework at a Given Time</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY},
    difficulty = Difficulty.EASY
)
public class Solution1450 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0, n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }
}