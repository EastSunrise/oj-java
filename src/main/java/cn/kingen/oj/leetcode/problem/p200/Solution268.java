package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/missing-number/">268. Missing Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution41
 * @see cn.kingen.oj.leetcode.problem.p100.Solution136
 * @see cn.kingen.oj.leetcode.problem.p200.Solution287
 * @see cn.kingen.oj.leetcode.problem.p700.Solution765
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH, Tag.BINARY_SEARCH, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution268 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (nums.length + 1) * nums.length / 2 - sum;
    }
}