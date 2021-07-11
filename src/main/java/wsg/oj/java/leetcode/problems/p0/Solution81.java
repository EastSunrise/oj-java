package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 81. Search in Rotated Sorted Array II (Medium)
 *
 * @author Kingen
 * @see Solution33
 * @see <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/">Search in
 * Rotated Sorted Array II</a>
 * @since 2021-07-11
 */
class Solution81 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean searchII(int[] nums, int target) {
        return searchII(nums, 0, nums.length - 1, target);
    }

    private boolean searchII(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal == target) {
                return true;
            }
            if (midVal < nums[high]) {
                if (midVal < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (midVal == nums[high]) {
                if (midVal == nums[low]) {
                    // can't determine the order
                    return searchII(nums, low + 1, mid - 1, target)
                        || searchII(nums, mid + 1, high - 1, target);
                } else {
                    high = mid - 1;
                }
            } else {
                if (midVal > target && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}
