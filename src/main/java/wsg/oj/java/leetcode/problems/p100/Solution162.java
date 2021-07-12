package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 162. Find Peak Element (Medium)
 *
 * @author Kingen
 * @see Solution852
 * @see Solution1901
 * @see <a href="https://leetcode-cn.com/problems/find-peak-element/">Find Peak Element</a>
 * @since 2021-07-12
 */
class Solution162 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
