package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 154. Find Minimum in Rotated Sorted Array II (HARD)
 *
 * @author Kingen
 * @see Solution153
 * @see <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/">Find
 * Minimum in Rotated Sorted Array II</a>
 * @since 2021-07-27
 */
public class Solution154 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
                right--;
            }
        }
        return nums[left];
    }
}
