package cn.kingen.oj.leetcode.problem.p1100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/distance-between-bus-stops/">1184. Distance Between Bus Stops</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2361

 */
@Question(
    tags = {Tag.ARRAY},
    difficulty = Difficulty.EASY
)
public class Solution1184 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = start; i < destination; i++) {
            sum1 += distance[i];
        }
        for (int i = 0; i < start; i++) {
            sum2 += distance[i];
        }
        for (int i = destination; i < distance.length; i++) {
            sum2 += distance[i];
        }
        return Math.min(sum1, sum2);
    }
}