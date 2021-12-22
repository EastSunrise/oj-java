package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution33;

/**
 * 153. Find Minimum in Rotated Sorted Array (Medium)
 *
 * @author Kingen
 * @see Solution33
 * @see Solution154
 * @see <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">Find
 * Minimum in Rotated Sorted Array</a>
 */
public class Solution153 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                return nums[left];
            }
        }
        return nums[left];
    }
}
