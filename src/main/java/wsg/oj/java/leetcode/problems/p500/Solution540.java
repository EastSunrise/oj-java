package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 540. Single Element in a Sorted Array (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/single-element-in-a-sorted-array/">Single Element
 * in a Sorted Array</a>
 * @since 2021-07-20
 */
class Solution540 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == nums[mid - 1]) {
                if ((mid & 1) == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((mid & 1) == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
