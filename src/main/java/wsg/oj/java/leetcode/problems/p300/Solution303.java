package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 303. Range Sum Query - Immutable (Easy)
 *
 * @author Kingen
 * @see Solution304
 * @see Solution307
 * @see Solution325
 * @see <a href="https://leetcode-cn.com/problems/range-sum-query-immutable/">Range Sum Query -
 * Immutable</a>
 * @since 2021-07-13
 */
public class Solution303 implements Solution {

    static class NumArray {

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
}
