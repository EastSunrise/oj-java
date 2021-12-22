package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 81. Search in Rotated Sorted Array II (Medium)
 *
 * @author Kingen
 * @see Solution33
 * @see <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/">Search in
 * Rotated Sorted Array II</a>
 */
public class Solution81 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private boolean search(int[] nums, int low, int high, int target) {
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
                    return search(nums, low + 1, mid - 1, target)
                        || search(nums, mid + 1, high - 1, target);
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
