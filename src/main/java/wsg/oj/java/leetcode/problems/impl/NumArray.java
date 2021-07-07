package wsg.oj.java.leetcode.problems.impl;

import wsg.oj.java.leetcode.problems.Solution301;
import wsg.oj.java.leetcode.problems.p300.Solution304;
import wsg.oj.java.leetcode.problems.p300.Solution307;

/**
 * 303. Range Sum Query - Immutable (Easy)
 *
 * @author Kingen
 * @see Solution304
 * @see Solution307
 * @see Solution301#maxSubArrayLen(int[], int)
 * @see <a href="https://leetcode-cn.com/problems/range-sum-query-immutable/">Range Sum Query -
 * Immutable</a>
 * @since 2021-06-25
 */
public class NumArray {

    /**
     * sums[i]: the sum of nums[0,i)
     */
    private final int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
