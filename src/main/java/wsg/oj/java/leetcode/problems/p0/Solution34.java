package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.Complexity;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 34. Find First and Last Position of Element in Sorted Array (Medium)
 *
 * @author Kingen
 * @see Solution278
 * @see <a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find
 * First and Last Position of Element in Sorted Array</a>
 * @since 2021-07-10
 */
class Solution34 implements Solution {

    /**
     * Finds the left bound and the right bound successively with binary searching.
     *
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int[] res = new int[]{-1, -1};
        if (left == nums.length || nums[left] != target) {
            return res;
        }
        res[0] = left;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }
}
