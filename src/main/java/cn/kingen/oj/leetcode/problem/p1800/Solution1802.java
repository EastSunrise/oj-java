package cn.kingen.oj.leetcode.problem.p1800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/">1802. Maximum Value at a Given Index in a Bounded Array</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class Solution1802 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int maxValue(int n, int index, int maxSum) {
        long left = index, right = n - index - 1;
        if (left > right) {
            long temp = left;
            left = right;
            right = temp;
        }
        // if nums[index]>=right+1
        long dif = ((left + 1) * left + (right + 1) * right) / 2;
        if (n * (right + 1) - dif <= maxSum) {
            return (int) ((maxSum + dif) / n);
        }
        // if nums[index]<=left+1
        if (left * left + n >= maxSum) {
            return (int) Math.sqrt(maxSum - n) + 1;
        }
        // if left+1<nums[index]<=right
        double b = 2 * left - 1;
        double c = 2 * right + 2 - (left + 1) * left - 2L * maxSum;
        return (int) Math.floor((-b + Math.sqrt(b * b - 4 * c)) / 2);
    }
}