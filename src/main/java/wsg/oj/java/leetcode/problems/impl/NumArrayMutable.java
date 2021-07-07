package wsg.oj.java.leetcode.problems.impl;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 307. Range Sum Query - Mutable
 *
 * @author Kingen
 * @see NumArray
 * @see <a href="https://leetcode-cn.com/problems/range-sum-query-mutable/">Range Sum Query -
 * Mutable</a>
 * @see <a href="https://en.wikipedia.org/wiki/Segment_tree">Segment tree</a>
 * @since 2021/7/3
 */
public class NumArrayMutable extends Solution {

    private final int len;
    private final int[] segments;

    public NumArrayMutable(int[] nums) {
        len = nums.length;
        segments = new int[len * 4];
        build(nums, 0, 0, len - 1);
    }

    private void build(int[] nums, int idx, int fromIn, int toIn) {
        if (fromIn == toIn) {
            segments[idx] = nums[fromIn];
            return;
        }
        int mid = fromIn + ((toIn - fromIn) >>> 1);
        build(nums, idx * 2 + 1, fromIn, mid);
        build(nums, idx * 2 + 2, mid + 1, toIn);
        segments[idx] = segments[idx * 2 + 1] + segments[idx * 2 + 2];
    }

    /**
     * @see #TIME_LOG_N
     */
    public void update(int index, int val) {
        update(index, val, 0, 0, len - 1);
    }

    private void update(int target, int val, int idx, int fromIn, int toIn) {
        if (fromIn == toIn) {
            segments[idx] = val;
            return;
        }
        int mid = fromIn + ((toIn - fromIn) >>> 1);
        if (target <= mid) {
            update(target, val, idx * 2 + 1, fromIn, mid);
        } else {
            update(target, val, idx * 2 + 2, mid + 1, toIn);
        }
        segments[idx] = segments[idx * 2 + 1] + segments[idx * 2 + 2];
    }

    /**
     * @see #TIME_LOG_N
     */
    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, 0, len - 1);
    }

    private int sumRange(int left, int right, int idx, int fromIn, int toIn) {
        if (left <= fromIn && toIn <= right) {
            return segments[idx];
        }
        int mid = fromIn + ((toIn - fromIn) >>> 1);
        int sum = 0;
        if (left <= mid) {
            sum += sumRange(left, right, idx * 2 + 1, fromIn, mid);
        }
        if (right > mid) {
            sum += sumRange(left, right, idx * 2 + 2, mid + 1, toIn);
        }
        return sum;
    }
}
