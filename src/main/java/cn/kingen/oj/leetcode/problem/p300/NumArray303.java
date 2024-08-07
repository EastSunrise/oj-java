package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/">303. Range Sum Query - Immutable</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.NumMatrix
 * @see cn.kingen.oj.leetcode.problem.p300.NumArray307
 * @see cn.kingen.oj.leetcode.problem.p300.Solution325
 */
@Question(
        tags = {Tag.DESIGN, Tag.ARRAY, Tag.PREFIX_SUM},
        difficulty = Difficulty.EASY
)
public class NumArray303 {

    /**
     * sums[i]: the sum of nums[0,i-1]
     */
    private final int[] sums;

    public NumArray303(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}