package cn.kingen.oj.leetcode.problem.p1000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/car-pooling/">1094. Car Pooling</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution253
 */
@Question(
        tags = {Tag.ARRAY, Tag.PREFIX_SUM, Tag.SORTING, Tag.SIMULATION, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1094 {

    @Complexity(time = "O(n+l)", space = "O(l)")
    public boolean carPooling(int[][] trips, int capacity) {
        int minLocation = Integer.MAX_VALUE, maxLocation = 0;
        for (int[] ints : trips) {
            minLocation = Math.min(ints[1], minLocation);
            maxLocation = Math.max(ints[2], maxLocation);
        }
        int[] changes = new int[maxLocation + 1];
        for (int[] trip : trips) {
            changes[trip[1]] += trip[0];
            changes[trip[2]] -= trip[0];
        }
        int count = 0;
        for (int i = minLocation; i <= maxLocation; i++) {
            count += changes[i];
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }
}