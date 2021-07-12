package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution33;

/**
 * 153. Find Minimum in Rotated Sorted Array (Medium)
 *
 * @author Kingen
 * @see Solution33
 * @see Solution154
 * @see <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">Find
 * Minimum in Rotated Sorted Array</a>
 * @since 2021-07-12
 */
public class Solution153 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
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
