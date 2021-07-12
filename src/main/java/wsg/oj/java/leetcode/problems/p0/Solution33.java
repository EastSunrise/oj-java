package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.Complexity;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution153;

/**
 * 33. Search in Rotated Sorted Array (Medium)
 *
 * @author Kingen
 * @see Solution81
 * @see Solution153
 * @see <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/">Search in Rotated
 * Sorted Array</a>
 * @since 2021-07-10
 */
public class Solution33 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
